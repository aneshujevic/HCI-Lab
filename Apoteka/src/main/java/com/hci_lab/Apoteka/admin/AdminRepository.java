package com.hci_lab.Apoteka.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByUsername(@Param("username") String username);
}
