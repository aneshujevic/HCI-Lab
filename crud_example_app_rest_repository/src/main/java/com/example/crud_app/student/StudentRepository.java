package com.example.crud_app.student;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    List<Student> findByName(@Param("name") String name);
    List<Student> findBySurname(@Param("surname") String surname);
    List<Student> findByNameOrSurname(@Param("name") String name, @Param("surname") String surname);
    List<Student> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
