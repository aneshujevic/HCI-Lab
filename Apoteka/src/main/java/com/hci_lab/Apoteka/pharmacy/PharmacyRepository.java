package com.hci_lab.Apoteka.pharmacy;

import com.hci_lab.Apoteka.location.Location;
import com.hci_lab.Apoteka.medication.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "pharmacies", itemResourceRel = "pharmacies")
public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {
    List<Pharmacy> findByLocation(@Param("location") Location location);

    List<Pharmacy> findByMedications(@Param("medication") Medication medication);
}
