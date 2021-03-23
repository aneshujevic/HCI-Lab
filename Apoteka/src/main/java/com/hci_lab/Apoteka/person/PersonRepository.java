package com.hci_lab.Apoteka.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByName(@Param("name") String name);

    List<Person> findBySurname(@Param("surname") String surname);

    List<Person> findByPosition(@Param("position") Position position);
}
