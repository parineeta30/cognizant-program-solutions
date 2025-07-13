package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.text.ParseException;
import java.util.Date;


@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
public static void main(String[] args) {
    LOGGER.info("START");
    SpringApplication.run(SpringLearnApplication.class, args);
    // displayDate();  // <-- Add this
    displayCountry();
    LOGGER.info("END");
    

}
public static void displayCountry() {
    LOGGER.info("START");

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    Country country = context.getBean("country", Country.class);
    Country anotherCountry = context.getBean("country", Country.class);

    LOGGER.debug("Country : {}", country.toString());
    LOGGER.debug("Another Country : {}", anotherCountry.toString());

    LOGGER.info("END");
}

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
