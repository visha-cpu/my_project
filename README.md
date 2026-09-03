# 🏥 Hospital Management System (HMS)

A robust and modular **Java Maven project** designed to automate and streamline core hospital operations including patient admissions, doctor allocations, appointment scheduling, and billing management.

---

## 🚀 Key Features

* **Patient Management:** Register, update, and search patient details and medical history.
* **Doctor Management:** Track doctor availability, specialization, and department assignments.
* **Appointment Scheduling:** Book, reschedule, and cancel patient appointments with doctors.
* **Billing System:** Generate invoices for consultations, treatments, and hospital stays.
* **Role-Based Access:** Standard admin/receptionist workflow for data security.

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java (JDK 17+)
* **Build Tool:** Apache Maven
* **Database:** MySQL
* **Database Driver:** MySQL Connector/J (`mysql-connector-j`)
* **Logging/Testing:** JUnit 5, SLF4J

---

## 📁 Project Structure

```text
hospital-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hospital/
│   │   │       ├── model/         # Patient, Doctor, Appointment entities
│   │   │       ├── dao/           # Database Access Layer (JDBC)
│   │   │       ├── service/       # Business logic layer
│   │   │       └── Main.java      # Application Entry Point
│   │   └── resources/
│   │       ├── db.properties      # Database connection configuration
│   │       └── schema.sql         # Database tables script
│   └── test/                      # Unit tests
├── pom.xml                        # Maven configuration & dependencies
└── README.md
