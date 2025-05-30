# 🚀 Team 5 - Parabank Test Automation Project

## 📌 Overview

## 📌 Overview

This Java Selenium project uses the **Cucumber BDD framework** to automate test scenarios for [Parabank](https://parabank.parasoft.com/), a virtual banking application used for software testing. Although it is not a real financial system, it provides an ideal simulated environment for practicing and executing automation tests.

The project includes end-to-end test coverage for common banking operations such as user registration, account creation, bill payment, fund transfers, contact information updates, and loan applications. Test cases are written using **Gherkin syntax** and implemented through **Cucumber step definitions**, ensuring a behavior-driven development (BDD) approach.


---

## ✅ Covered Test Scenarios

### ✔️ User Registration (US601)
- Automates the process of creating a new user account.
- Inputs valid data (name, address, username, password).
- Verifies successful registration and redirection.

### ✔️ User Login (US602)
- Tests login functionality with valid credentials.
- Confirms redirection to user dashboard after login.

### ❌ Invalid Login Attempt
- Attempts to log in with incorrect credentials.
- Verifies that appropriate error messages are shown.

### ✔️ Bill Payment (US603)
- Automates payment process for utilities (electricity, water, gas).
- Ensures transaction is processed and confirmed.

### ✔️ Open New Bank Account (US604)
- Allows the user to open checking or savings accounts.
- Confirms the new account is added to the user's profile.

### ✔️ Transfer Between Accounts (US605)
- Transfers funds between user's own accounts.
- Validates balance updates and transaction history.

### ✔️ Update Contact Information (US606)
- Allows updating of address, phone number, and email.
- Verifies success message and data changes.

### ✔️ Loan Application (US607)
- Submits a loan request with input values.
- Confirms whether the loan is approved or denied.

---

## 🛠 Technologies & Tools

- **Java** – Test scripting  
- **Selenium WebDriver** – Browser automation  
- **Cucumber** – BDD support  
- **TestNG** – Testing framework  
- **Page Object Model (POM)** – Design pattern  
- **Maven** – Build & dependency management  
- **ExtentReports / Allure** – Reporting  
- **Slf4j** – Logging  
- **JIRA / XRAY** – Test management  
- **WebDriverManager** – Driver management  

---

## 🌍 Test Environment

Tests are executed in the following environment:

🔗 [https://parabank.parasoft.com/](https://parabank.parasoft.com/)

---

## 📥 Setup & Execution

### ✅ Prerequisites

- Java JDK 11+
- Maven 3.8+
- Git
- IDE (IntelliJ IDEA, Eclipse, etc.)


🤝 Contributors

| Name                     | Role                 | GitHub                                                |
|--------------------------|----------------------|--------------------------------------------------------|
| **Serkan Sewöster**      | Team Lead / PO       | [SerkanSewoester](https://github.com/SerkanSewoester) |
| **Ennur Göl**            | QA Automation Tester | [ennur7](https://github.com/ennur7)                   |
| **Burak Bora Durmaz**    | QA Automation Tester | [burakboradurmaz](https://github.com/burakboradurmaz) |
| **Melike Emine Özyavuz** | QA Automation Tester | [melekOz2](https://github.com/melekOz2)               |
| **İbrahim Can**          | QA Automation Tester | [ibcan9](https://github.com/ibcan9)                   |
| **Hakan Mert**           | QA Automation Tester | [hakan-mert](https://github.com/hakan-mert)           |
| **Murat Öksüz**          | QA Automation Tester | [muratoksuz](https://github.com/muratoksuz)           |
| **Tuğba Yılmaz**         | QA Automation Tester | [MTY-EEE](https://github.com/MTY-EEE)                 |

### 🔧 Installation

```bash
git clone https://github.com/SerkanSewoester/Team5Parabank.git
cd Team5Parabank
mvn clean install




