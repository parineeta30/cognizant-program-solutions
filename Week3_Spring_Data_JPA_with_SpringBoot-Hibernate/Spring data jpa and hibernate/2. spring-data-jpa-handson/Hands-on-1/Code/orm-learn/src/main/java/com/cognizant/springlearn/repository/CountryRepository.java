package com.cognizant.springlearn.repository;

import com.cognizant.springlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContaining(String substring);
    List<Country> findByNameContainingOrderByNameAsc(String substring);
    List<Country> findByNameStartingWith(String prefix);
}
