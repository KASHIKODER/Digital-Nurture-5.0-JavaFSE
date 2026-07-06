# Week 3 - Spring REST using Spring Boot 3

**Program:** Cognizant Digital Nurture 5.0 — Java FSE Angular
**Week:** 3 (2 Jul — 8 Jul 2026)
**Track:** Java FSE Angular (Role 5)
**Topic:** Spring REST API Development using Spring Boot 3

---

## ? Mandatory Hands-On Completed

| # | Exercise | Status |
|---|---|---|
| 1 | Spring Web Project using Maven | ? |
| 2 | Hello World RESTful Web Service | ? |
| 3 | REST Country Web Service — GET all | ? |
| 4 | REST Country Web Service — GET by country code | ? |
| 5 | POST, PUT, DELETE endpoints | ? |
| 6 | Global Exception Handling | ? |
| 7 | Input Validation with @Valid | ? |

---

## ?? Folder Structure

Week_3/
+-- SpringRESTDemo/
    +-- pom.xml
    +-- src/main/
        +-- java/com/cognizant/
        ¦   +-- App.java
        ¦   +-- controller/CountryController.java
        ¦   +-- service/CountryService.java
        ¦   +-- repository/CountryRepository.java
        ¦   +-- entity/Country.java
        ¦   +-- exception/GlobalExceptionHandler.java
        +-- resources/
            +-- application.properties

---

## ?? Module 7 — Spring REST using Spring Boot 3

### What is REST API?

REST = Representational State Transfer

- **Resource** = koi bhi data — Country, Student, User
- **HTTP** = communication protocol
- **JSON** = data format — request aur response dono mein
- **Stateless** = har request independent — server state store nahi karta

### REST API Flow

Client (Postman/Browser)
        ? HTTP Request (JSON)
@RestController  ? request receive karo
        ?
@Service         ? business logic
        ?
@Repository      ? DB se data fetch karo
        ?
Database (H2/MySQL)
        ? JSON Response wapas

---

### HTTP Methods

| Method | Kaam | Status Code |
|---|---|---|
| GET | Data fetch karo | 200 OK |
| POST | Naya record banao | 201 Created |
| PUT | Poora record update karo | 200 OK |
| PATCH | Partial update | 200 OK |
| DELETE | Record delete karo | 200 OK |

---

### Key Annotations

| Annotation | Kaam |
|---|---|
| @SpringBootApplication | Main class — @Configuration + @EnableAutoConfiguration + @ComponentScan |
| @RestController | Controller class — @Controller + @ResponseBody |
| @RequestMapping | Base URL define karo |
| @GetMapping | GET endpoint |
| @PostMapping | POST endpoint |
| @PutMapping | PUT endpoint |
| @DeleteMapping | DELETE endpoint |
| @PathVariable | URL se value — /countries/IN |
| @RequestParam | Query param — /countries?code=IN |
| @RequestBody | JSON body ? Java object |
| @Valid | Input validation |
| @ControllerAdvice | Global exception handler |

---

### HTTP Status Codes — yaad karo

| Code | Matlab | Kab |
|---|---|---|
| 200 | OK | GET/PUT/DELETE success |
| 201 | Created | POST success |
| 400 | Bad Request | Invalid input |
| 401 | Unauthorized | Login nahi kiya |
| 404 | Not Found | Resource nahi mila |
| 500 | Internal Server Error | Server crash |

---

### REST API Development Flow

1. Entity define karo (@Entity)
2. Repository banao (JpaRepository extend karo)
3. Service layer likho (business logic)
4. Controller banao (@RestController)
5. Exception handler banao (@ControllerAdvice)
6. Postman se test karo

---

### Code Examples

#### Entity
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryCode;
    private String countryName;
}

#### Repository
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByCountryCode(String countryCode);
}

#### Controller
@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @GetMapping
    public ResponseEntity<List<Country>> getAll() {
        return ResponseEntity.ok(service.getAllCountries());
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getByCode(@PathVariable String code) {
        return service.getByCountryCode(code)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> add(@Valid @RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.addCountry(country));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id,
                                          @RequestBody Country country) {
        return ResponseEntity.ok(service.updateCountry(id, country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteCountry(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}

#### Global Exception Handler
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

---

### API Endpoints — Tested

| Method | URL | Description |
|---|---|---|
| GET | /api/countries/hello | Hello World |
| GET | /api/countries | All countries |
| GET | /api/countries/{code} | Country by code |
| POST | /api/countries | Add country |
| PUT | /api/countries/{id} | Update country |
| DELETE | /api/countries/{id} | Delete country |

---

### REST Best Practices

**HTTP Status Codes** — Sahi code return karo — 200, 201, 404, 500

**Global Exception Handling** — @ControllerAdvice use karo — centralized error handling

**Input Validation** — @Valid + @NotBlank, @NotNull, @Size annotations

**Layered Architecture** — Controller ? Service ? Repository ? Entity

**Stateless** — Har request mein sab info honi chahiye — server pe state mat rakho

---

### Spring Boot Key Concepts

**Auto-configuration:**
Spring Boot classpath scan karta hai aur automatically beans configure karta hai

**Embedded Tomcat:**
Alag server install nahi karna — Spring Boot mein built-in hai

**application.properties:**
server.port=8081
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop

**@SpringBootApplication = 3 annotations:**
@Configuration + @EnableAutoConfiguration + @ComponentScan

---

### MCQ + Interview Prep

**Q1.** @RestController = kaunse 2 annotations?
? @Controller + @ResponseBody

**Q2.** POST ka success status code?
? 201 Created

**Q3.** @PathVariable vs @RequestParam?
? PathVariable — URL mein /countries/IN
? RequestParam — query string mein /countries?code=IN

**Q4.** @ControllerAdvice kya karta hai?
? Global exception handler — sab controllers ke exceptions ek jagah handle

**Q5.** REST stateless kya matlab?
? Har request independent — server client ka koi state store nahi karta

**Q6.** ResponseEntity kyu use karte hain?
? HTTP status code + response body dono control karne ke liye

**Q7.** @Valid kab use karte hain?
? Request body ka input validate karne ke liye — @NotBlank, @Size ke saath

**Q8.** Spring Boot mein default embedded server?
? Tomcat

**Q9.** PUT vs PATCH difference?
? PUT — poora resource replace. PATCH — sirf kuch fields update.

**Q10.** 404 status code kab aata hai?
? Requested resource server pe nahi mila

---

## ??? Tech Stack Used

- **Language:** Java 21
- **Framework:** Spring Boot 3.3
- **Database:** H2 In-Memory
- **ORM:** Spring Data JPA + Hibernate
- **Build Tool:** Maven 3.9
- **Testing Tool:** Browser / Postman
- **IDE:** VS Code

---

*Cognizant Digital Nurture 5.0 | Java FSE Angular Track | 2026*
