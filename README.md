# E-Commerce Microservice Project

## Overview
This project is a microservices-based architecture designed for e-commerce operations. It consists of multiple microservices for handling different functionalities like authentication, product management, order processing, payment, and more. The system also includes centralized configuration, service discovery, API Gateway, and distributed tracing.

### Microservices and Components
- **API Gateway**: Routes and secures requests to the microservices, with rate limiting and circuit breaker mechanisms.
- **Authentication Service (ms-auth)**: Handles user authentication using JWT (JSON Web Tokens).
- **Product Service (ms-product)**: Manages product-related operations.
- **Order Service (ms-order)**: Handles order creation and management.
- **Payment Service (ms-payment)**: Processes payments for orders.
- **Eureka Server**: Provides service discovery for all microservices.
- **Config Server**: Supplies centralized configuration for the services.

---

## Features
1. **Authentication**:
   - User login and registration with JWT-based authentication.
   - Token-based security integrated with API Gateway.
2. **API Gateway**:
   - Handles all incoming requests.
   - Integrated with Resilience4j for rate limiting and circuit breaker functionality.
   - Swagger-enabled OpenAPI documentation for all microservices.
3. **Distributed Tracing**:
   - Zipkin is used for distributed tracing of requests across microservices.
4. **Service Discovery and Configuration**:
   - Eureka Server for service registration and discovery.
   - Config Server for managing centralized configurations.
5. **Resilience4j**:
   - Rate limiter and circuit breaker mechanisms to ensure system stability.
6. **Swagger Integration**:
   - OpenAPI documentation for testing and exploring APIs via Swagger UI.

---

## Technologies and Tools
- **Spring Boot**: Framework for building microservices.
- **Spring Cloud**: For service discovery, configuration, and resilience.
- **Feign Client**: For inter-service communication.
- **Resilience4j**: Circuit breaker and rate limiter.
- **JWT**: Secure user authentication.
- **Zipkin**: Distributed tracing.
- **Swagger/OpenAPI**: API documentation and testing.

---

## Project Structure
```plaintext
e-commerce-microservice-project/
├── api-gateway          # API Gateway service
├── config-server        # Centralized configuration
├── eureka-server        # Service registry and discovery
├── ms-auth              # Authentication service
├── ms-order             # Order service
├── ms-payment           # Payment service
├── ms-product           # Product service
├── README.md            # Project documentation
└── build.gradle.kts     # Gradle configuration
