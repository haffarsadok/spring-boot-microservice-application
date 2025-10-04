# 🏥 Spring Boot Microservice Healthcare Application

A comprehensive healthcare management system built with Spring Boot microservices architecture, designed to manage patients and doctors (médecins) efficiently.

## 📋 Table of Contents
- [Overview](#overview)
- [Microservices Architecture](#microservices-architecture)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## 🎯 Overview

This application demonstrates a modern microservices architecture for healthcare management, providing separate services for patient management, doctor (médecin) management, along with supporting infrastructure services for configuration, service discovery, and API gateway functionality.

## 🏗️ Microservices Architecture

### Core Services

#### 🏥 Patient Service
- **Purpose**: Manages patient records and related operations
- **Port**: Usually runs on `8081`
- **Entities**: Patient (id, nom, prenom, age, tel)
- **Endpoints**: 
  - `POST /api/patient/add` - Add new patient
  - `GET /api/patient/all` - Retrieve all patients

#### 👨‍⚕️ Med Service (Doctor Service)
- **Purpose**: Manages doctor records and medical staff information
- **Port**: Usually runs on `8082`
- **Entities**: Medecin (id, nom, prenom, specialite, adresse)
- **Endpoints**:
  - `POST /api/medecin/add` - Add new doctor
  - `GET /api/medecin/all` - Retrieve all doctors

### Infrastructure Services

#### 🌐 Gateway Service
- **Purpose**: API Gateway for routing requests to appropriate microservices
- **Technology**: Spring Cloud Gateway
- **Features**: 
  - Dynamic service discovery integration
  - Request routing
  - Load balancing

#### 🔍 Discovery Service
- **Purpose**: Service registry and discovery using Netflix Eureka
- **Technology**: Spring Cloud Netflix Eureka Server
- **Port**: Usually runs on `8761`
- **Dashboard**: `http://localhost:8761`

#### ⚙️ Config Service
- **Purpose**: Centralized configuration management
- **Technology**: Spring Cloud Config Server
- **Features**: External configuration management across all microservices

## 🛠️ Technologies Used

- **Framework**: Spring Boot 3.x
- **Cloud**: Spring Cloud 2022.x
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Database**: JPA/Hibernate with H2 (development)
- **Build Tool**: Maven
- **Language**: Java 17+
- **Annotations**: Lombok for boilerplate code reduction

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git

### Installation & Setup

1. **Clone the repository**
```bash
git clone https://github.com/haffarsadok/spring-boot-microservice-application.git
cd spring-boot-microservice-application
```

2. **Start services in the following order:**

   **Step 1: Start Discovery Service**
   ```bash
   cd discovery-service
   mvn spring-boot:run
   ```
   Wait for Eureka server to start (usually on port 8761)

   **Step 2: Start Config Service**
   ```bash
   cd config-service
   mvn spring-boot:run
   ```

   **Step 3: Start Business Services**
   ```bash
   # Terminal 1 - Patient Service
   cd patient-service
   mvn spring-boot:run

   # Terminal 2 - Med Service
   cd med-service
   mvn spring-boot:run
   ```

   **Step 4: Start Gateway Service**
   ```bash
   cd gateway-service
   mvn spring-boot:run
   ```

3. **Verify Services**
   - Eureka Dashboard: `http://localhost:8761`
   - All services should be registered and UP

## 📚 API Documentation

### Patient Service API

#### Add Patient
```http
POST /api/patient/add
Content-Type: application/json

{
  "nom": "Doe",
  "prenom": "John",
  "age": 30,
  "tel": 123456789
}
```

#### Get All Patients
```http
GET /api/patient/all
```

**Response:**
```json
[
  {
    "id": 1,
    "nom": "Doe",
    "prenom": "John",
    "age": 30,
    "tel": 123456789
  }
]
```

### Med Service API

#### Add Doctor
```http
POST /api/medecin/add
Content-Type: application/json

{
  "nom": "Smith",
  "prenom": "Dr. Jane",
  "specialite": "Cardiologie",
  "adresse": "123 Medical Center"
}
```

#### Get All Doctors
```http
GET /api/medecin/all
```

**Response:**
```json
[
  {
    "id": 1,
    "nom": "Smith",
    "prenom": "Dr. Jane",
    "specialite": "Cardiologie",
    "adresse": "123 Medical Center"
  }
]
```

## 📁 Project Structure

```
spring-boot-microservice-application/
├── patient-service/           # Patient management microservice
│   ├── src/main/java/
│   │   └── com/service/patient/
│   │       ├── controller/    # REST Controllers
│   │       ├── entity/        # JPA Entities
│   │       ├── repository/    # Data Repositories
│   │       ├── service/       # Business Logic
│   │       └── PatientServiceApplication.java
│   └── pom.xml
├── med-service/               # Doctor management microservice
│   ├── src/main/java/
│   │   └── com/service/med/
│   │       ├── controller/    # REST Controllers
│   │       ├── entity/        # JPA Entities
│   │       ├── repository/    # Data Repositories
│   │       ├── service/       # Business Logic
│   │       └── MedServiceApplication.java
│   └── pom.xml
├── gateway-service/           # API Gateway
│   ├── src/main/java/
│   │   └── service/gateway/
│   │       └── GatewayServiceApplication.java
│   └── pom.xml
├── discovery-service/         # Service Discovery (Eureka)
│   ├── src/main/java/
│   │   └── service/discovery/
│   │       └── DiscoveryServiceApplication.java
│   └── pom.xml
├── config-service/           # Configuration Server
│   ├── src/main/java/
│   │   └── service/config/
│   │       └── ConfigServiceApplication.java
│   └── pom.xml
└── README.md
```

## 🔧 Configuration

Each microservice can be configured through `application.yml` or `application.properties` files. The Config Service enables centralized configuration management.

### Key Configuration Points:
- **Service Discovery**: All services register with Eureka
- **Database**: H2 in-memory database for development
- **Ports**: Each service runs on different ports to avoid conflicts
- **Profiles**: Different profiles for dev, test, and production environments

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Haffar Sadok**
- GitHub: [@haffarsadok](https://github.com/haffarsadok)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Spring Cloud for microservices infrastructure
- Netflix OSS for Eureka service discovery

---

⭐ If you found this project helpful, please give it a star!

