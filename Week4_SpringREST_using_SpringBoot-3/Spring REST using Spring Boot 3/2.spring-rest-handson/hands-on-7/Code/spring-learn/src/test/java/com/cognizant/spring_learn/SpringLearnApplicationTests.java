package com.cognizant.spring_learn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cognizant.spring_learn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/countries/in")); // corrected URL
    actions.andExpect(status().isOk());
    actions.andExpect(jsonPath("$.code").exists());
    actions.andExpect(jsonPath("$.code").value("IN"));
    actions.andExpect(jsonPath("$.name").exists());
    actions.andExpect(jsonPath("$.name").value("India"));
}

}
