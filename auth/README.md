# Auth Microservice

This is a Spring Boot application that provides authentication and authorization services for other microservices. Which returns the user's JWT token in the header of `/api/users/login` endpoint.
## Table of Content

- [Stack](#stack)
- [Authentication and Authorization](#authentication-and-authorization)
- [API Documentation](./API.md)

## Stack

Technologies Used:

- Spring Boot
- Spring Security
- Maven
- Tomcat

## Authentication and Authorization

Password based authentication scheme is implemented using BCrypt for hashing passwords to be stored. Password is
validated against some rules:

- Length (8 ~ 16 characters)
- One Upper-case character at least
- One Lower-case character at least
- One Digit character at least
- One Symbol at least
- No Whitespaces
- No Sequence characters or digits (Less than 5 characters is allowed)

Spring Security configuration is customized by Servlet Filters to handle login requests by Bearer Authentication using
JSON Web Tokens (JWT), and verify Authorizations for all endpoints except Create and Login API endpoints.

### Stack

- JUnit 5
- Mockito
- MockMVC

# Testing

Unit tests is implemented demonstrating 86% code coverage.