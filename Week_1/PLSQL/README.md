# Week 1 - PL/SQL Programming

**Program:** Cognizant Digital Nurture 5.0 - Java FSE Angular  
**Week:** 1 (18 Jun - 24 Jun 2026)  
**Topic:** PL/SQL Programming with Oracle Database

---

## Database Schema

5 tables created:
- **Customers** — CustomerID, Name, DOB, Balance, LastModified
- **Accounts** — AccountID, CustomerID, AccountType, Balance
- **Transactions** — TransactionID, AccountID, TransactionDate, Amount
- **Loans** — LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate
- **Employees** — EmployeeID, Name, Position, Salary, Department

---

## Exercise 1 - Control Structures

**File:** `Exercise1_ControlStructures.sql`

### Scenario 1: Loan Interest Discount for Senior Customers
- **Problem:** Apply 1% discount on loan interest for customers above 60
- **Concept:** FOR loop + IF condition + MONTHS_BETWEEN()
- **Output:** "No discount for: John Doe" (age < 60)

### Scenario 2: VIP Status Based on Balance
- **Problem:** Set IsVIP = TRUE for customers with balance > 10,000
- **Concept:** FOR loop + IF condition + ALTER TABLE + UPDATE
- **Output:** "John Doe is not VIP", "Jane Smith is not VIP" (balance < 10,000)

### Scenario 3: Loan Due Reminders
- **Problem:** Print reminders for loans due within next 30 days
- **Concept:** FOR loop + WHERE clause with SYSDATE + 30
- **Output:** No reminders (loan due after 60 months)

---

## Exercise 3 - Stored Procedures

**File:** `Exercise3_StoredProcedures.sql`

### Scenario 1: Process Monthly Interest
- **Procedure:** `ProcessMonthlyInterest`
- **Problem:** Apply 1% interest to all Savings accounts monthly
- **Concept:** UPDATE with percentage calculation
- **Output:** "Monthly interest applied to all savings accounts"

### Scenario 2: Update Employee Bonus
- **Procedure:** `UpdateEmployeeBonus(department, bonus_percentage)`
- **Problem:** Add bonus to all employees in a given department
- **Concept:** Parameterized procedure + UPDATE by department
- **Output:** "Bonus applied to department: IT"

### Scenario 3: Transfer Funds
- **Procedure:** `TransferFunds(from_account, to_account, amount)`
- **Problem:** Transfer amount between accounts with balance check
- **Concept:** SELECT INTO + balance validation + dual UPDATE
- **Output:** "Rs.500 transferred successfully"

---

## Key PL/SQL Concepts Used

| Concept | Used In |
|---|---|
| FOR Loop | Ex 1 — all scenarios |
| IF-ELSE | Ex 1 — all scenarios |
| STORED PROCEDURE | Ex 3 — all scenarios |
| COMMIT | All exercises |
| DBMS_OUTPUT.PUT_LINE | All exercises |
| SYSDATE | Date calculations |
| MONTHS_BETWEEN() | Age calculation |
| ADD_MONTHS() | Loan end date |
| SELECT INTO | Balance check |

---

## Tool Used
- **Oracle Live SQL** — livesql.oracle.com

---

*Cognizant Digital Nurture 5.0 | Java FSE Angular Track | 2026*