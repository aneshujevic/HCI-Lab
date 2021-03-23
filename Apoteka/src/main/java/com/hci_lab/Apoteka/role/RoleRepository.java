package com.hci_lab.Apoteka.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(@Param("role") String role);
}
