# Hands-on 6: Find a Country Based on Country Code

## Objective
Fetch a specific country from the database using its country code and handle cases where the country may not exist.

---

## Steps Performed

### 1. Created Custom Exception
- **Class**: `CountryNotFoundException`
- **Package**: `com.cognizant.springlearn.service.exception`
- Thrown when a country with the given code is not found.

### 2. Added Service Method
- **Class**: `CountryService`
- **Method**:
```java
@Transactional
public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
    Optional<Country> result = countryRepository.findById(countryCode);
    if (!result.isPresent()) {
        throw new CountryNotFoundException("Country not found with code: " + countryCode);
    }
    return result.get();
}
