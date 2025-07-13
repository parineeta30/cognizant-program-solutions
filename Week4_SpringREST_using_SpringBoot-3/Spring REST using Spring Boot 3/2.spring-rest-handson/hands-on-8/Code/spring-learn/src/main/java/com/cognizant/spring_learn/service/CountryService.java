package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) throws CountryNotFoundException {
        List<Country> countryList = new ArrayList<>();

        Country country1 = new Country();
        country1.setCode("IN");
        country1.setName("India");

        Country country2 = new Country();
        country2.setCode("US");
        country2.setName("United States");

        Country country3 = new Country();
        country3.setCode("JP");
        country3.setName("Japan");

        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);

        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country Not found"));
    }
}
