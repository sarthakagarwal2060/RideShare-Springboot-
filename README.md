# RideShare Backend (Spring Boot + MongoDB)

This project is a simple backend system similar to a basic Uber flow. It supports user and driver registration, login with JWT authentication, and a complete ride workflow including requesting, accepting, and completing rides.

## Understanding the Project in Simple Language

The task was to build a backend that works like a small version of Uber. A user should be able to request a ride, and a driver should be able to view available rides, accept one, and later complete it. The system should securely store users and rides in a cloud database and allow only authorized people to perform actions using JWT tokens.

You created a clean, structured backend that includes authentication, role-based access, and complete ride management.

## Features Implemented

### Authentication
- Register as a user or driver.
- Login using username and password.
- Generate JWT token after login.
- Validate JWT for protected APIs.

### User and Driver Roles
- Users can request rides.
- Drivers can accept rides.
- Drivers can complete rides.

### Ride Management
- Request a ride.
- View all pending rides.
- Accept a ride.
- Complete a ride.
- Ride statuses: REQUESTED, ACCEPTED, COMPLETED.

### MongoDB Atlas Integration
- All user data stored in cloud.
- All ride records stored in cloud.
- Fully remote connection (no local MongoDB needed).

### Clean Backend Architecture
- Controllers handle API requests.
- Services contain business logic.
- Repositories talk to MongoDB.
- DTOs used for clean request and response models.
- Models represent collections in MongoDB.
- Security config and JWT helper classes for authentication.

## Tech Stack Used

- Java Spring Boot 3
- Spring Security
- JWT Authentication
- MongoDB Atlas
- Maven

## API Endpoints Overview

Auth Endpoints:
- POST /auth/register
- POST /auth/login

Ride Endpoints:
- POST /ride/request
- GET /ride/available
- POST /ride/accept/{rideId}
- POST /ride/complete/{rideId}

## Project Structure Overview

src/main/java/org/example/rideshare  
- config  
- controller  
- dto  
- model  
- repository  
- service  
- util  

RideShareApplication.java

## How to Run the Project

1. Clone the repository.
2. Update application.properties with your MongoDB URI.
3. Run the command: mvn spring-boot:run

## Summary

This project demonstrates how to build a real backend system with authentication, role handling, cloud database integration, and a ride workflow similar to Uber. It is structured cleanly and is a good example of backend engineering with Spring Boot.

