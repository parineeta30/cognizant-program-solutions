package com.cognizant.springlearn;

import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmApplication.class);

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext context = SpringApplication.run(OrmApplication.class, args);
        CountryService countryService = context.getBean(CountryService.class);
        testUpdateCountry(countryService);  //  Hands-on 8
    }

    private static void testUpdateCountry(CountryService countryService) throws CountryNotFoundException {
        LOGGER.info("Start - testUpdateCountry");

        String code = "NP"; // Country code that exists in DB
        String newName = "Federal Republic of Nepal";

        countryService.updateCountry(code, newName);  // ✅ Update

        LOGGER.info("Updated Country: {}", countryService.findCountryByCode(code));

        LOGGER.info("End - testUpdateCountry");
    }
}
