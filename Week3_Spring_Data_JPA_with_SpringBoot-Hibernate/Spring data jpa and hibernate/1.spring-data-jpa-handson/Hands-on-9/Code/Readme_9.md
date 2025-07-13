# Hands-on 9: Delete a Country Based on Code

## Objective :
Delete an existing country from the database using Spring Data JPA.

---

## Steps Performed

1. **Updated `CountryService`**
   - Created a method `deleteCountry(String code)` annotated with `@Transactional`
   - Used `countryRepository.deleteById(code)` to remove the record

2. **Updated `OrmApplication` (Test Class)**
   - Added a method `testDeleteCountry()`:
     - Called `deleteCountry("NP")` to delete a country
     - Confirmed the deletion using log output

---

## Code Snippet

### `CountryService.java`
```java
@Transactional
public void deleteCountry(String code) {
    countryRepository.deleteById(code);
}
```
## Sample Output:
Start - testDeleteCountry
Hibernate: delete from country where co_code=?
Deleted country with code: NP
End - testDeleteCountry

