🧩 Spring Boot CRUD API

A simple CRUD (Create, Read, Update, Delete) REST API built using Spring Boot.
This repository contains two branches demonstrating different setups of the same project:

main branch → uses H2 in-memory database for quick testing.

post branch → upgraded version using PostgreSQL, validation, pagination, Swagger, and JWT authentication.

🚀 Features (main branch)

✅ Create, Read, Update, Delete operations

✅ In-memory H2 Database for lightweight testing

✅ JPA + Hibernate integration

✅ Simple REST architecture

✅ Easy to run and test locally

🧩 Additional Features (post branch)

Branch: post

The post branch enhances the base CRUD API with industry-level backend features:

🗄️ PostgreSQL integration (instead of H2)

🔐 JWT Authentication & Authorization using Spring Security

🧾 Request Validation using Hibernate Validator annotations (@NotNull, @Email, etc.)

📄 API Documentation via Swagger / OpenAPI

🔁 Pagination & Sorting support using Pageable

⚙️ Configurable application.yml for environment setup

🧱 Modular structure (Controller, Service, Repository, DTO, Config)

🏗️ Tech Stack
Layer	Technology
Language	Java
Framework	Spring Boot
Database	H2 (Main branch) / PostgreSQL (Post branch)
ORM	Hibernate (Spring Data JPA)
Security	Spring Security, JWT
Documentation	Swagger (Springdoc OpenAPI)
Build Tool	Maven
📂 Project Structure
src/
 └── main/
     ├── java/dev/codeio/helloworld/
     │    ├── controller/    # REST Controllers
     │    ├── service/       # Business logic
     │    ├── repository/    # Data access layer
     │    ├── model/         # Entity classes
     │    ├── dto/           # Request/Response objects (post branch)
     │    ├── config/        # Security, Swagger, DB configuration (post branch)
     │    └── HelloworldApplication.java
     └── resources/
          ├── application.properties / application.yml
          └── data.sql / schema.sql (optional)

⚙️ Configuration
🧱 Main Branch (H2)
spring.application.name=helloworld

spring.datasource.url=jdbc:h2:mem:tododb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=1234

spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

🗄️ Post Branch (PostgreSQL + JWT)
spring.datasource.url=jdbc:postgresql://localhost:5432/crud_db
spring.datasource.username=crud_user
spring.datasource.password=password123
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
jwt.secret=YOUR_SECRET_KEY
jwt.expirationMs=3600000

# Swagger Configuration
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

🧠 How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/nitheshkumar-it20/CRUD-in-Springboot.git
cd CRUD-in-Springboot

2️⃣ Choose the Branch

For H2 version:

git checkout main


For PostgreSQL version:

git checkout post

3️⃣ Build and Run
mvn spring-boot:run

🌐 Accessing the Application
Branch	Base URL	Database Console	Swagger UI
main (H2)	http://localhost:8080	http://localhost:8080/h2-console	—
post (PostgreSQL)	http://localhost:8080	via PostgreSQL client	http://localhost:8080/swagger-ui.html
📮 Example Endpoints
Method	Endpoint	Description
POST	/api/todos	Create a new record
GET	/api/todos	Get all records (with pagination in post branch)
GET	/api/todos/{id}	Get record by ID
PUT	/api/todos/{id}	Update record
DELETE	/api/todos/{id}	Delete record
🔐 JWT Authentication (Post Branch)

Obtain a token by calling /api/auth/login with valid credentials.

Use the token in the Authorization header for secure routes:

Authorization: Bearer <your_token_here>


Tokens expire after a configurable duration (jwt.expirationMs).

🧾 Validation Example
public class UserRequest {
    @NotBlank(message = "Username must not be empty")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}

🔁 Pagination Example
GET /api/todos?page=0&size=10&sort=title,asc


Response includes metadata such as total pages, total elements, and current page.

🧠 Swagger UI

Access at: http://localhost:8080/swagger-ui.html

Try out endpoints interactively.

Auto-generated documentation via annotations.

🧑‍💻 Author

Nithesh Kumar
🎓 B.Tech (Information Technology), BIT Sathy
💡 Passionate about backend development, DBMS, and OOPs, with 1.5 years of experience
