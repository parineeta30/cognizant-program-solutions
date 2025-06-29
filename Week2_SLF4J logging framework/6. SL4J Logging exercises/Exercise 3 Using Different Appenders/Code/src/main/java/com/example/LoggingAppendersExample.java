package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAppendersExample.class);

    public static void main(String[] args) {
        logger.info("Logging to both console and file");
        logger.warn("This is a warning");
        logger.error("This is an error message");
    }
}
