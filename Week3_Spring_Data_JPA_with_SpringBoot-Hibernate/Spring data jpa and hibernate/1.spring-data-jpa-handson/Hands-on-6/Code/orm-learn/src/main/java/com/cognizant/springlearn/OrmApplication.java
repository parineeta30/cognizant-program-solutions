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
    }

    private static void getCountryByCodeTest(CountryService countryService) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End");
    }
}
