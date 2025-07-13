package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> searchByNameSubstring(String substring) {
        return countryRepository.findByNameContaining(substring);
    }

    public List<Country> searchByNameSubstringSorted(String substring) {
        return countryRepository.findByNameContainingOrderByNameAsc(substring);
    }

    public List<Country> getCountriesByAlphabet(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}