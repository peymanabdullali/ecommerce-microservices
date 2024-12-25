# Project Overview

This project is based on a microservices architecture and consists of the following microservices:

- **Product Service**: Provides product management functionality.
- **Order Service**: Manages order operations.
- **Payment Service**: Handles payment processes.
- **Eureka Server**: Used for service discovery and registration.
- **Config Server**: Provides centralized configuration management.

## Technologies

The project uses the following technologies and tools:

1. **Spring Boot**: Core framework for microservice development.
2. **Feign Client**: REST client for inter-service communication.
3. **Spring AOP**: For managing cross-cutting concerns (e.g., logging, security).
4. **Exception Handler**: Custom error handling.
5. **Spring Cloud Eureka**: Service discovery and load balancing.
6. **Spring Cloud Config**: Centralized configuration management.

## Services

### Product Service
- Communicates with other microservices using Feign Client.
- Logging and transaction management with AOP.
- Error management with a custom exception handler.


### Order Service
- Interacts with Product Service via Feign Client.
- Logs operations using AOP.
- Handles errors with a custom exception handler.


### Payment Service
- Processes payment operations.
- Communicates with Order Service using Feign Client.
- Logging with AOP and custom error handling.

### Eureka Server
- Registers all microservices.
- Enables service discovery among microservices.


### Config Server
- Manages centralized configuration files.
- Provides configuration to all microservices.

## Project Setup

- **Feign Client**: Enables communication between microservices. Each service defines interfaces to access other microservices.
- **Spring AOP**: Used for centralized logging and cross-cutting concerns.
- **Exception Handler**: Centralized error handling is implemented via custom exception handlers.
- **Eureka and Config Server**: Eureka Server provides service discovery, while Config Server simplifies centralized configuration management.

## How to Run

1. **Start the Config Server**
    - Run the Config Server to make the centralized configuration files accessible.

2. **Start the Eureka Server**
    - Start the Eureka Server to enable service registration and discovery.

3. **Start the Microservices**
    - Run Product, Order, and Payment services. These services will register with Eureka Server and fetch configuration from Config Server.

4. **Test API Requests**
    - Use Postman or similar tools to test the APIs provided by the microservices.

## Project Structure

```
project-root
|
├── config-server
├── eureka-server
├── product-service
├── order-service
├── payment-service
```

## Notes

- Each service can be run independently.
- Config Server and Eureka Server must be started before other microservices.
- Logging and error handling are centralized to avoid code duplication.

