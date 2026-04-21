# stock-portfolio-management
REST API backend for managing stock investments built with Spring Boot, JPA/Hibernate, and MySQL. Supports CRUD on holdings with real-time portfolio metrics (P&amp;L, total value).

# Stock Portfolio Management System

A RESTful backend API built with **Spring Boot**, **MySQL**, and **JPA/Hibernate** that allows users to manage their stock investments — track holdings, calculate profit/loss, and monitor portfolio value.


## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA + Hibernate
- MySQL 8
- Maven
- REST API
- Postman (for testing)

##  Architecture

```
com.portfolio
├── entity
│   ├── User.java
│   ├── Stock.java
│   └── Holding.java
├── repository
│   ├── UserRepository.java
│   ├── StockRepository.java
│   └── HoldingRepository.java
├── service
│   └── PortfolioService.java
├── dto
│   ├── HoldingResponse.java
│   └── PortfolioResponse.java
└── controller
    └── PortfolioController.java
```


##  API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/portfolio` | Get all holdings with portfolio metrics |
| POST | `/portfolio` | Add a new holding |
| PUT | `/portfolio/{userId}` | Update a holding |
| DELETE | `/portfolio/{id}` | Delete a holding |

---

##  Setup

1. Clone the repo and create a MySQL database named `stock_portfolio_db`
2. Add your credentials to `src/main/resources/application.properties`
3. Run `mvn spring-boot:run`
4. Insert sample users and stocks via SQL before testing
