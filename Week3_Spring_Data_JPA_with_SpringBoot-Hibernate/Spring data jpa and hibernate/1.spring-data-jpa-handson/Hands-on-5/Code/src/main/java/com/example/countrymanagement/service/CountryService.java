package com.example.countrymanagement.service;

import com.example.countrymanagement.entity.Country;
import com.example.countrymanagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountry(String code) {
        System.out.println("Fetching country with code: " + code);

        return countryRepository.findById(code).orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, Country updated) {
        Country existing = getCountry(code);
        if (existing != null) {
            existing.setName(updated.getName());
            return countryRepository.save(existing);
        }
        return null;
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchCountries(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}
