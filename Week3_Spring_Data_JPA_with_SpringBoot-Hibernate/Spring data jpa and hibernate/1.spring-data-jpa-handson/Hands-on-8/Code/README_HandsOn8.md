# Hands-on 8: Update a Country Based on Code

## Objective :
Update a country's name in the database using its code through Spring Data JPA.

---

## Tasks Performed :

### 1. `CountryService` Modification
- Created method: `updateCountry(String code, String name)`
- Annotated with `@Transactional`
- Used `findById(code)` to fetch the `Country` object
- Set new name using `country.setName(name)`
- Saved the updated country with `countryRepository.save(country)`

### 2. `OrmApplication.java`
- Added a new test method `testUpdateCountry()`
- Called `updateCountry("NP", "Federal Republic of Nepal")` to update Nepal’s name

### 3. Console Output Verified:
- Hibernate logs confirmed SELECT and UPDATE queries
- Log message printed:
  ```
  Updated Country: Country [code=NP, name=Federal Republic of Nepal]
  ```

### 4. Database Verification:
- Update was successful, verify in MySQL using:
  ```sql
  SELECT * FROM country WHERE co_code = 'NP';
  ```

---

##  Files Modified:
- `CountryService.java`
- `OrmApplication.java`

##  Build and Run Status:
- **BUILD SUCCESS** with updated Hibernate logs
- Application terminated cleanly

---

