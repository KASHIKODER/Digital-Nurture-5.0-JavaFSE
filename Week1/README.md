# Week 1 - Design Patterns, DSA & Algorithms

**Program:** Cognizant Digital Nurture 5.0 - Java FSE Angular  
**Week:** 1 (18 Jun - 24 Jun 2026)  
**Topics:** Design Principles, Design Patterns, Data Structures & Algorithms

---

## Mandatory Hands-On Completed

### Module 1 - Design Patterns and Principles

#### Exercise 1: Singleton Pattern
- **Scenario:** Logging utility with single instance throughout application lifecycle
- **Concept:** Private constructor + Static instance + Public getInstance() method
- **Key Learning:** Only one object created — verified using `==` operator
- **Location:** `SingletonPatternExample/src/`

#### Exercise 2: Factory Method Pattern
- **Scenario:** Document management system — Word, PDF, Excel documents
- **Concept:** Abstract factory + Concrete factories + Product interface
- **Key Learning:** Object creation abstracted — subclass decides which object to create
- **Location:** `FactoryMethodPatternExample/src/`

---

### Module 2 - Data Structures and Algorithms

#### Exercise 2: E-commerce Platform Search Function
- **Scenario:** Search optimization for e-commerce platform
- **Concept:** Linear Search vs Binary Search
- **Key Learning:**
  - Linear Search: O(n) — checks every element
  - Binary Search: O(log n) — eliminates half each time
  - Binary Search requires sorted array
- **Location:** `EcommerceSearch/src/`

#### Exercise 7: Financial Forecasting
- **Scenario:** Predict future values based on past growth rates
- **Concept:** Recursive algorithm for compound growth
- **Key Learning:**
  - Time Complexity: O(n) — n recursive calls
  - Space Complexity: O(n) — n call stack frames
  - Optimization: Memoization to avoid redundant calls
- **Location:** `FinancialForecasting/src/`

---

## Concepts Covered

### SOLID Principles
| Principle | One Line |
|---|---|
| Single Responsibility | Ek class = ek kaam |
| Open/Closed | Extend karo, modify mat karo |
| Liskov Substitution | Child class parent ki jagah safely use ho |
| Interface Segregation | Fat interface mat banao |
| Dependency Inversion | Abstraction pe depend karo |

### Design Patterns Overview
| Pattern | Category | Use Case |
|---|---|---|
| Singleton | Creational | Single DB connection, Logger |
| Factory Method | Creational | Object creation without specifying class |
| Builder | Creational | Complex object step by step |
| Adapter | Structural | Incompatible interfaces bridge |
| Decorator | Structural | Add behavior at runtime |
| Observer | Behavioral | One change, notify all |
| Strategy | Behavioral | Algorithm switch at runtime |
| MVC | Architectural | UI and logic separation |

### DSA Complexity Reference
| Algorithm | Best | Average | Worst |
|---|---|---|---|
| Linear Search | O(1) | O(n) | O(n) |
| Binary Search | O(1) | O(log n) | O(log n) |
| Recursion (Financial) | O(n) | O(n) | O(n) |

---

## Folder Structure