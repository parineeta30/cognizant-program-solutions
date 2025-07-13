package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> optional = countryRepository.findById(code);
        if (!optional.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }

        Country country = optional.get();
        country.setName(name);
        countryRepository.save(country);
    }

    public Country findCountryByCode(String code) throws CountryNotFoundException {
        return countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));
    }
}
