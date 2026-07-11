# Week 4 - JWT Security, Microservices with Spring Boot 3 and Spring Cloud

**Program:** Cognizant Digital Nurture 5.0 - Java FSE Angular
**Week:** 4 (9 Jul - 15 Jul 2026)
**Track:** Java FSE Angular (Role 5)
**Topics:** JWT Authentication, Microservices Architecture, SonarQube, Code Quality

---

## Mandatory Hands-On Completed

| # | Module | Exercise | Status |
|---|---|---|---|
| 1 | Spring Security + JWT | Create Authentication Service that returns JWT | Done |
| 2 | Microservices | Creating Account Microservice | Done |
| 3 | Microservices | Creating Loan Microservice | Done |

---

## Folder Structure

Week_4/
 JWTSecurity/
    pom.xml
    src/main/java/com/cognizant/
        App.java
        config/SecurityConfig.java
        controller/AuthController.java
        model/AuthRequest.java
        model/AuthResponse.java
        service/JwtService.java
 Microservices/
     account-service/
        pom.xml
        src/main/java/com/cognizant/account/
            AccountServiceApp.java
            controller/AccountController.java
            model/Account.java
     loan-service/
         pom.xml
         src/main/java/com/cognizant/loan/
             LoanServiceApp.java
             controller/LoanController.java
             model/Loan.java

---

## Module - JWT Authentication

### What is JWT

JWT = JSON Web Token

JWT ek secure way hai information transmit karne ka between client and server.

Structure:
HEADER.PAYLOAD.SIGNATURE

Example:
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXlhc2gifQ.abc123

### JWT 3 Parts

| Part | Content | Example |
|---|---|---|
| Header | Algorithm + token type | HS256, JWT |
| Payload | Claims - username, expiry | sub, iat, exp |
| Signature | Header + Payload + Secret | HMACSHA256(...) |

### JWT Flow

Client  POST /api/auth/login (username + password)
         
Server validates credentials
         
Server generates JWT token
         
Client receives token
         
Client sends token in every request header
         
Server validates token  allow/deny

### Key Annotations Used

| Annotation | Kaam |
|---|---|
| @EnableWebSecurity | Spring Security enable karo |
| @Configuration | Config class |
| SessionCreationPolicy.STATELESS | JWT stateless hai - server session store nahi karta |

### API Endpoints

| Method | URL | Description |
|---|---|---|
| POST | /api/auth/login | Username+password  JWT token |
| GET | /api/auth/validatetoken=xxx | Token validate karo |
| GET | /api/auth/hello | Health check |

### Test Credentials

Username: suyash
Password: password123

---

## Module - Microservices Architecture

### What are Microservices

Application ko chote independent services mein todo - har service ek specific business function kare.

### Monolithic vs Microservices

| Feature | Monolithic | Microservices |
|---|---|---|
| Structure | Ek bada app | Choti independent services |
| Deployment | Poora app deploy | Sirf affected service deploy |
| Scaling | Poora app scale | Sirf heavy service scale |
| Failure | Ek fail = sab fail | Ek fail = baki chal rahi |
| Technology | Ek tech stack | Har service alag tech |

### Account Service

- Port: 8083
- Spring Application Name: account-service
- Base URL: /api/accounts

Endpoints:

| Method | URL | Description |
|---|---|---|
| GET | /api/accounts | All accounts |
| GET | /api/accounts/{id} | Account by ID |
| POST | /api/accounts | Create account |
| GET | /api/accounts/health | Health check |

### Loan Service

- Port: 8084
- Spring Application Name: loan-service
- Base URL: /api/loans

Endpoints:

| Method | URL | Description |
|---|---|---|
| GET | /api/loans | All loans |
| GET | /api/loans/{id} | Loan by ID |
| POST | /api/loans | Create loan |
| GET | /api/loans/health | Health check |

### Key Microservices Concepts

| Concept | Matlab |
|---|---|
| Service Independence | Har service independently deploy aur scale hoti hai |
| Database per Service | Har service ka apna DB - loose coupling |
| API Gateway | Single entry point - routing + auth + rate limiting |
| Service Discovery | Eureka - services ek doosre ko dhundh sakein |
| Circuit Breaker | Failing service bypass karo - fallback do |
| Load Balancing | Requests distribute karo multiple instances mein |

### Spring Cloud Components

| Component | Kaam |
|---|---|
| Eureka Server | Service Discovery and Registration |
| Spring Cloud Gateway | API Gateway - routing |
| Feign Client | Service to service REST calls |
| Resilience4j | Circuit Breaker - fault tolerance |
| Config Server | Centralized configuration |

---

## Module - SonarQube and Code Quality

### What is SonarQube

Static code analysis tool - bina code run kiye bugs, vulnerabilities, code smells detect karta hai.

### SonarQube 5 Issue Types

| Issue | Matlab |
|---|---|
| Bugs | Actual code defects |
| Vulnerabilities | Security issues |
| Code Smells | Maintainability issues |
| Duplicated Code | Same code multiple jagah |
| Technical Debt | Fix karne mein estimated time |

### Quality Gate

Predefined quality threshold - fail hone pe deployment blocked hota hai.

### Maven Command

mvn clean verify sonar:sonar

### Coding Standards Summary

| Rule | Standard |
|---|---|
| Class name | Capital letter se shuru - UserService |
| Method name | Small letter se shuru - getUserById() |
| Variable name | Meaningful - userCount not uc |
| Method size | Max ~200 lines |
| Comments | Class level + Method level dono mandatory |
| Packages | Business need ke according - com.cognizant.service |

---

## MCQ Quick Revision

**JWT:**
Q: JWT ka full form  JSON Web Token
Q: JWT ke 3 parts  Header.Payload.Signature
Q: JWT stateless kyu  Server session store nahi karta
Q: Signing algorithm  HMACSHA256

**Microservices:**
Q: Database per service kyu  Loose coupling + autonomy
Q: API Gateway kya karta hai  Routing + Auth + Rate limiting
Q: Circuit Breaker kab use  Failing service bypass karne ke liye
Q: Eureka kya hai  Service Discovery + Registration

**SonarQube:**
Q: Static vs Runtime analysis  SonarQube = Static
Q: Quality Gate kya hai  Deployment blocker if quality fails
Q: Maven command  mvn clean verify sonar:sonar

---

## Tech Stack Used

| Category | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.3, Spring Security |
| Security | JWT (JJWT 0.11.5) |
| Architecture | Microservices |
| Build Tool | Maven 3.9 |
| IDE | VS Code |
| Testing | Browser / Postman |

---

*Cognizant Digital Nurture 5.0 | Java FSE Angular Track | 2026*
