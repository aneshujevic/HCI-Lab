package com.hci_lab.Apoteka.location;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {
    List<Location> findByCity(@Param("city") String city);

    List<Location> findByCountry(@Param("country") String country);
}
