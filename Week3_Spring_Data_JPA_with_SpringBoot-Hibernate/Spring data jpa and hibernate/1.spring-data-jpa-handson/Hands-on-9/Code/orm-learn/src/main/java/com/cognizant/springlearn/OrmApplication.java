package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext context = SpringApplication.run(OrmApplication.class, args);
        CountryService countryService = context.getBean(CountryService.class);
        getCountryByCodeTest(countryService);
        testAddCountry(countryService); // added country
        testDeleteCountry(countryService); // delete country
    }

    private static void testDeleteCountry(CountryService countryService) {
        LOGGER.info("Start - testDeleteCountry");

        String countryCode = "NP"; // or any code you added during testAddCountry

        countryService.deleteCountry(countryCode); // delete operation

        LOGGER.debug("Deleted country with code: {}", countryCode);

        LOGGER.info("End - testDeleteCountry");
    }

    private static void getCountryByCodeTest(CountryService countryService) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End");
    }

    private static void testAddCountry(CountryService countryService) throws CountryNotFoundException {
        LOGGER.info("Start - testAddCountry");

        Country country = new Country();
        country.setCode("NP"); // or any new unique code
        country.setName("Nepal");

        countryService.addCountry(country); // Step 1: Add

        Country addedCountry = countryService.findCountryByCode("NP"); // Step 2: Retrieve

        LOGGER.debug("Added Country: {}", addedCountry); // Step 3: Log output

        LOGGER.info("End - testAddCountry");
    }

}