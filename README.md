
# 🏥 Patient Microservice (Tutorial-based)

This project is a simple **Patient Management Microservice**, developed as part of learning gRPC microservices and Spring Boot backend design patterns. It includes core REST functionality for creating, updating, retrieving, and deleting patients, with layered architecture and validation.

---

## 📘 Disclaimer

This project was built by closely following a YouTube tutorial on Java gRPC microservices.  
All architecture, naming conventions, and logic are based on the tutorial content.  
Uploaded strictly for **educational and personal learning purposes**.

---

## 🚀 Features

- ✅ RESTful API for managing patients
- 🎯 DTO ↔ Entity mapping using `PatientMapper`
- 📧 Email uniqueness validation
- 🧪 Bean Validation with `@Validated` and validation groups
- 🛡 Custom exceptions: `EmailAlreadyExistsException`, `PersonWasNotFoundException`
- 📄 Swagger/OpenAPI annotations (`@Tag`, `@Operation`)
- 💉 Spring Boot Dependency Injection (`@Service`, `@RestController`)
- 🧼 Clean, layered architecture

---

## 📂 Project Structure

```
/src/main/java/com/pm/patientservice
  ├── controller
  │   └── PatientController.java
  ├── service
  │   └── PatientService.java
  ├── model
  │   └── Patient.java
  ├── dto
  │   └── PatientRequestDto.java
  ├── mapper
  │   └── PatientMapper.java
  ├── repository
  │   └── PatientRepository.java
  ├── exception
      ├── EmailAlreadyExistsException.java
      └── PersonWasNotFoundException.java
```

---

## 🔌 API Endpoints

| Method | Endpoint           | Description                  |
|--------|--------------------|------------------------------|
| GET    | /patients/getAll   | Get all patients             |
| POST   | /patients/create   | Create new patient           |
| PUT    | /patients/update   | Update patient by UUID       |
| DELETE | /patients/delete   | Delete patient by UUID       |

---

## 💡 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate Validator
- OpenAPI / Swagger
- Lombok

---

## 🛠️ Getting Started

```bash
git clone https://github.com/yourusername/patient-service-tutorial.git
cd patient-service-tutorial
./mvnw spring-boot:run
```

---

## 👤 Author

Built for educational purposes by **Abden Alisher**  
Based on content from YouTube tutorial series on gRPC + Spring Boot

---

## 📄 License

This repository is intended for educational purposes only. Do not use for commercial applications.
