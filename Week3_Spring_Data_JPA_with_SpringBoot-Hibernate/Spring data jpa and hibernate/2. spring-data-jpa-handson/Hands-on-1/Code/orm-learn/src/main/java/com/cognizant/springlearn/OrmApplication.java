package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmApplication.class, args);
        CountryService countryService = context.getBean(CountryService.class);

        testSearchBySubstring(countryService);
        testSearchBySubstringSorted(countryService);
        testCountriesByAlphabet(countryService);
    }

    private static void testSearchBySubstring(CountryService countryService) {
        LOGGER.info("--- Search by Substring ---");
        List<Country> results = countryService.searchByNameSubstring("ou");
        results.forEach(c -> LOGGER.debug(c.toString()));
    }

    private static void testSearchBySubstringSorted(CountryService countryService) {
        LOGGER.info("--- Search by Substring Sorted ---");
        List<Country> results = countryService.searchByNameSubstringSorted("ou");
        results.forEach(c -> LOGGER.debug(c.toString()));
    }

    private static void testCountriesByAlphabet(CountryService countryService) {
        LOGGER.info("--- Countries Starting with Z ---");
        List<Country> results = countryService.getCountriesByAlphabet("Z");
        results.forEach(c -> LOGGER.debug(c.toString()));
    }
}
