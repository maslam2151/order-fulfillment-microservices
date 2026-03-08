# Order Fulfillment Microservices System

A distributed backend system built using **Java and Spring Boot microservices** to simulate a real-world order processing workflow.

The system contains two independent services that communicate through REST APIs.

Order Service → Handles customer orders  
Inventory Service → Manages product stock

When an order is created, the Order Service checks the Inventory Service to verify stock availability before confirming the order.

---

# Architecture

Client Request
      |
      v
Order Service (Port 8080)
      |
REST API Call
      |
Inventory Service (Port 8081)
      |
Database (H2 / JPA)

---

# Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- REST APIs
- Maven
- H2 Database
- Microservices Architecture
- Git

---

# Microservices

## Order Service

Handles order processing.

Endpoints:

POST /orders  
GET /orders

Example request:

```json
{
  "productId": "P100",
  "quantity": 2
}
```

Before creating an order, the service calls the Inventory Service to check if the product is available.

---

## Inventory Service

Manages product inventory.

Endpoints:

POST /inventory  
GET /inventory/check

Example request:

```json
{
  "productId": "P100",
  "quantity": 10
}
```

---

# Running the Project

Start Inventory Service:

```
cd inventory-service
mvn spring-boot:run
```

Start Order Service:

```
cd order-service
mvn spring-boot:run
```

Services will run on:

```
Order Service     http://localhost:8080
Inventory Service http://localhost:8081
```

---

# Example Workflow

1. Add inventory through the Inventory Service.
2. Send an order request to the Order Service.
3. Order Service calls Inventory Service.
4. If stock exists → order is created.
5. If stock does not exist → error returned.

---

# Future Improvements

- Docker containerization
- PostgreSQL database
- Service discovery (Eureka)
- API Gateway
- AWS deployment

---

# Author

Mohammed Aslam  
GitHub: https://github.com/maslam2151
