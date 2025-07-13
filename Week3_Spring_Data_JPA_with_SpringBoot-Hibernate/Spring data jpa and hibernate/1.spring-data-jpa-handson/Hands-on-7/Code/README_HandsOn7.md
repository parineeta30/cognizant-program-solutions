# Hands-on 7: Add a Country Using Spring Data JPA

## Objective
To create a new country entry in the database using Spring Data JPA.

## Steps Performed :

1. **Entity Class: `Country`**
   - Fields: `code`, `name`
   - Annotated with `@Entity`, `@Table(name = "country")`
   - Setters and getters implemented

2. **Repository Interface: `CountryRepository`**
   - Extends `JpaRepository<Country, String>`

3. **Service Class: `CountryService`**
   - Method: `addCountry(Country country)`
   - Calls `countryRepository.save(country)`

4. **Test Method in `OrmApplication`**
   - Method: `testAddCountry()`
   - Creates and saves a new country (e.g., Nepal - `NP`)

## Output Log :
```
Start - testAddCountry
Added Country: Country [code=NP, name=Nepal]
End - testAddCountry
```

## Outcome :
The country `Nepal` with code `NP` is successfully inserted into the database.

