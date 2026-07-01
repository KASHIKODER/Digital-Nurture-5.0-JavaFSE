# Week 2 - Spring Core, Spring Data JPA & Hibernate

**Program:** Cognizant Digital Nurture 5.0 — Java FSE Angular  
**Week:** 2 (25 Jun — 1 Jul 2026)  
**Track:** Java FSE Angular (Role 5)  
**Topics:** Spring Core & Maven, Spring Data JPA with Spring Boot, Hibernate

---

## ✅ Mandatory Hands-On Completed

| # | Module | Exercise | Status |
|---|---|---|---|
| 1 | Spring Core & Maven | Configuring a Basic Spring Application | ✅ |
| 2 | Spring Core & Maven | Implementing Dependency Injection | ✅ |
| 3 | Spring Core & Maven | Creating and Configuring a Maven Project | ✅ |
| 4 | Spring Data JPA | Quick Example — CRUD with Spring Data JPA + H2 | ✅ |

---

## 📁 Folder Structure
Week_2/
├── SpringCoreDemo/
│   ├── pom.xml
│   └── src/main/java/com/cognizant/
│       ├── App.java
│       ├── UserRepository.java
│       ├── UserRepositoryImpl.java
│       └── UserService.java
└── SpringDataJPA/
├── pom.xml
└── src/main/
├── java/com/cognizant/
│   ├── App.java
│   ├── entity/Student.java
│   ├── repository/StudentRepository.java
│   └── service/StudentService.java
└── resources/
└── application.properties
---

## 📘 Module 5 — Spring Core & Maven

### What is Spring Framework?
Spring is Java's most popular framework that simplifies enterprise application development
by providing **Inversion of Control (IoC)** and **Dependency Injection (DI)** out of the box.

---

### Core Concept 1 — IoC (Inversion of Control)

> "Object khud nahi banata — Spring banata hai aur de deta hai"

**Without Spring (tightly coupled):**
```java
UserRepository repo = new UserRepositoryImpl(); // tu khud bana raha hai
UserService service = new UserService(repo);     // manually inject kar raha hai
```

**With Spring (loosely coupled):**
```java
// Spring khud banata hai aur inject karta hai
ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
UserService service = context.getBean(UserService.class); // bas maango
```

**Why IoC?**
- Loose coupling — classes ek doosre pe directly depend nahi karti
- Easy testing — mock inject kar sakte ho
- Easy to swap implementations

---

### Core Concept 2 — DI (Dependency Injection)

> "Jo cheez chahiye woh bahar se inject hoti hai — andar se nahi banti"

**3 types of DI:**

| Type | How | When to use |
|---|---|---|
| Constructor Injection | `@Autowired` on constructor | Mandatory dependencies — **recommended** |
| Setter Injection | `@Autowired` on setter | Optional dependencies |
| Field Injection | `@Autowired` on field | Quick but not recommended for prod |

**Constructor Injection (Best Practice):**
```java
@Service
public class UserService {
    private final UserRepository userRepository; // final — immutable

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; // Spring inject karega
    }
}
```

---

### Key Spring Annotations

| Annotation | Purpose |
|---|---|
| `@Component` | Generic Spring bean |
| `@Service` | Service layer bean |
| `@Repository` | Data access layer bean |
| `@Controller` | Web layer bean |
| `@Autowired` | Inject dependency automatically |
| `@Configuration` | Java config class |
| `@ComponentScan` | Tell Spring where to look for beans |
| `@Bean` | Manual bean definition |

---

### Spring Bean Lifecycle

Spring Container starts
↓
@ComponentScan — beans dhundho
↓
Bean instantiate karo (constructor call)
↓
Dependencies inject karo (@Autowired)
↓
Bean ready — use karo
↓
Container close — beans destroy

---

### Maven — Key Concepts

**Maven kya hai?**
- Build tool + dependency manager
- `pom.xml` mein dependencies declare karo — Maven download karta hai

**`pom.xml` structure:**
```xml
<project>
    <groupId>com.cognizant</groupId>      <!-- company/org name -->
    <artifactId>SpringCoreDemo</artifactId> <!-- project name -->
    <version>1.0-SNAPSHOT</version>         <!-- version -->

    <dependencies>
        <!-- yahan libraries add karo -->
    </dependencies>
</project>
```

**Maven build lifecycle:**

validate → compile → test → package → install → deploy

**Common Maven commands:**
| Command | Kaam |
|---|---|
| `mvn compile` | Code compile karo |
| `mvn test` | Tests run karo |
| `mvn package` | JAR/WAR banao |
| `mvn clean` | Build folder delete karo |
| `mvn spring-boot:run` | Spring Boot app run karo |

---

### Exercise Output

=== Spring Core Demo ===
--- Ex 1: Spring IoC Container ---
Spring Container started successfully!
Beans managed by Spring: 6
--- Ex 2: Dependency Injection ---
Fetching user from DB with id: 1
Found user: Suyash Giri
Saving user to DB: Karan
--- Ex 4: Maven Project ---
Maven project configured successfully!
Spring version: 6.1.10
=== All exercises complete! ===


---

## 📘 Module 6 — Spring Data JPA with Spring Boot & Hibernate

### What is JPA?

| Term | Full Form | Kya hai |
|---|---|---|
| JPA | Java Persistence API | Specification — rules define karta hai |
| Hibernate | — | JPA ka implementation — actual kaam karta hai |
| Spring Data JPA | — | Hibernate ke upar layer — aur easy banata hai |

**Simple flow:**
Code → Spring Data JPA → Hibernate → Database

---

### Key JPA Annotations

| Annotation | Purpose | Example |
|---|---|---|
| `@Entity` | Class = DB table | `@Entity public class Student` |
| `@Table` | Table name specify | `@Table(name = "students")` |
| `@Id` | Primary key | `@Id private Long id` |
| `@GeneratedValue` | Auto increment ID | `@GeneratedValue(strategy = IDENTITY)` |
| `@Column` | Column mapping | `@Column(name = "student_name")` |
| `@OneToMany` | One-to-many relation | Parent → children |
| `@ManyToOne` | Many-to-one relation | Child → parent |

---

### Spring Data JPA Repository

> "Sirf interface banao — Spring Data JPA implement karta hai"

```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // CRUD methods FREE milte hain — likhe bina!
    // save(), findAll(), findById(), deleteById() — sab ready

    // Custom query — method naam se automatically query banti hai
    List<Student> findByDepartment(String department);
    Student findByEmail(String email);
}
```

**JpaRepository se milne wale free methods:**
| Method | Kaam |
|---|---|
| `save(entity)` | Insert / Update |
| `findAll()` | Sab records |
| `findById(id)` | ID se dhundho |
| `deleteById(id)` | Delete karo |
| `count()` | Total count |
| `existsById(id)` | Exists check |

---

### Derived Query Methods

> "Method ka naam likho — Spring Data JPA query khud banata hai"

| Method Name | Generated Query |
|---|---|
| `findByName(String name)` | `WHERE name = ?` |
| `findByDepartment(String dept)` | `WHERE department = ?` |
| `findByNameAndDepartment(...)` | `WHERE name = ? AND department = ?` |
| `findByAgeGreaterThan(int age)` | `WHERE age > ?` |
| `findByNameContaining(String s)` | `WHERE name LIKE %s%` |
| `countByDepartment(String dept)` | `COUNT WHERE department = ?` |

---

### application.properties — Key Config

```properties
# H2 In-Memory Database (testing ke liye)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop  # app start pe table create, stop pe drop
spring.jpa.show-sql=true                    # SQL queries console pe dikhao
```

**`ddl-auto` options:**
| Value | Kab use karein |
|---|---|
| `create-drop` | Testing — app stop pe sab delete |
| `update` | Development — existing data safe |
| `validate` | Production — sirf validate, change nahi |
| `none` | Production — Spring kuch nahi karta |

---

### Exercise Output

=== Spring Data JPA Demo ===
--- Saving Students ---
Hibernate: insert into students (department,email,name) values (?,?,?)
--- All Students ---
Student{id=1, name='Suyash Giri', email='suyash@kiit.ac.in', dept='CSE'}
Student{id=2, name='Karan Sharma', email='karan@kiit.ac.in', dept='CSE'}
Student{id=3, name='Priya Singh', email='priya@kiit.ac.in', dept='ECE'}
--- Student by ID 1 ---
Student{id=1, name='Suyash Giri', email='suyash@kiit.ac.in', dept='CSE'}
--- Students in CSE ---
Student{id=1, name='Suyash Giri', ...}
Student{id=2, name='Karan Sharma', ...}
--- Deleting Student ID 3 ---
After delete — total students: 2
=== Spring Data JPA Complete! ===