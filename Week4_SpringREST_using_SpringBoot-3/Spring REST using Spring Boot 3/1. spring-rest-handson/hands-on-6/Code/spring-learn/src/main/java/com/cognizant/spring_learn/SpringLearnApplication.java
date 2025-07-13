package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.util.List;


@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
public static void main(String[] args) {
    LOGGER.info("START");
    SpringApplication.run(SpringLearnApplication.class, args);
    displayCountries();

    // displayDate();  // <-- Add this
    // displayCountry();
    LOGGER.info("END");
    
}


public static void displayCountries() {
    LOGGER.info("START");

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    List<Country> countryList = context.getBean("countryList", List.class);

    LOGGER.debug("Country List: {}", countryList);

    LOGGER.info("END");
}
// public static void displayCountry() {
//     LOGGER.info("START");

//     ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

//     Country country = context.getBean("country", Country.class);
//     Country anotherCountry = context.getBean("country", Country.class);

//     LOGGER.debug("Country : {}", country.toString());
//     LOGGER.debug("Another Country : {}", anotherCountry.toString());

//     LOGGER.info("END");
// }

//     public static void displayDate() {
//     LOGGER.info("START");
//     ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
//     SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
//     try {
//         Date date = format.parse("31/12/2018");
//         LOGGER.debug("Parsed Date: {}", date);
//     } catch (ParseException e) {
//         e.printStackTrace(); // You can log this too if needed
//     }
//     LOGGER.info("END");
// }


}
