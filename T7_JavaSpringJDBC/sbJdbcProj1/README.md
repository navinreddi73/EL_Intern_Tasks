Here’s a complete README.md template for your Task 7 👇

# Task 7: Java JDBC - Employee/User Database App (Spring JDBC)

## 📌 Objective
A simple **Spring Boot + Spring JDBC** application to perform **CRUD operations** (Create, Read, Update, Delete) on a MySQL database.  
This task demonstrates database connectivity, DAO layer, and `JdbcTemplate` usage.

---

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot 3.x**
- **Spring JDBC (JdbcTemplate)**
- **MySQL 8+**
- **Maven/Gradle** (build tool)
- IDE: VS Code / IntelliJ IDEA

---

## 📂 Project Structure


EL_Intern_Tasks/
└── EL_Tasks/
└── T7_SpringJDBC_CRUD/
├── src/main/java/in/edify/main/
│ ├── SbJdbcProj1Application.java # Main Spring Boot class
│ ├── dao/UserDao.java # DAO layer with CRUD
│ ├── entities/User.java # Entity class
│ └── mappers/UserRowMapper.java # RowMapper for User
└── src/main/resources/
└── application.properties # MySQL connection details


---

## 🗄️ Database Setup

1. Start MySQL server and create a new database:
   ```sql
   CREATE DATABASE edifydb;
   USE edifydb;

application.properties file

spring.application.name=sbJdbcProj1

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=*******

Create the users table:

CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL
);

⚙️ Spring Boot MySQL Configuration

In src/main/resources/application.properties:

# MySQL Database Connection
spring.datasource.url=jdbc:mysql://localhost:3306/edifydb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate (not used here, but optional)
spring.jpa.hibernate.ddl-auto=none

# Show SQL Logs
spring.jpa.show-sql=true


🔑 Replace root and yourpassword with your MySQL credentials.
Make sure port 3306 is correct (default for MySQL).

▶️ Running the Project

Open terminal in project folder.

Build the project:

mvn clean install


Run the application:

mvn spring-boot:run


or

java -jar target/T7_SpringJDBC_CRUD-0.0.1-SNAPSHOT.jar

📝 Example Operations (from CommandLineRunner)

Insert User

userDao.createUser(new User(1001, "naveen@gmail.com", "Naveen", "1234"));


Update User

userDao.updateUser(new User(1001, "naveen_updated@gmail.com", "Naveen Updated", "abcd"));


Delete User

userDao.deleteUser(1001);


Fetch by ID

User u = userDao.getUserById(1002);


Fetch All

List<User> users = userDao.getAllUsers();


Console Output Example:

User Data Inserted
User Updated
User Found: Naveen Updated
User Deleted
1002 | varma | varma@gmail.com
1003 | john  | john@gmail.com

🎯 Outcome

Learned how to connect Spring Boot with MySQL using Spring JDBC.

Implemented CRUD operations with JdbcTemplate.

Explored DAO design pattern in a real project.