package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void processAndSend(String input) {
        // Simulate some processing
        String processed = input.toUpperCase();
        api.sendData(processed);
    }
}
