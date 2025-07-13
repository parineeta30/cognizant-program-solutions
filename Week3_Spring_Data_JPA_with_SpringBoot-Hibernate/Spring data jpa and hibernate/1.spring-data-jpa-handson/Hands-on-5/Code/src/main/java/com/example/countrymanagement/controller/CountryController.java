package com.example.countrymanagement.controller;

import com.example.countrymanagement.entity.Country;
import com.example.countrymanagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country get(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country update(@PathVariable String code, @RequestBody Country country) {
        return countryService.updateCountry(code, country);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return countryService.searchCountries(name);
    }
}
