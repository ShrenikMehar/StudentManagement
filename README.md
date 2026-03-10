# Student REST API

## Overview

This project implements a simple REST API to manage student records.
The API allows clients to create, retrieve, update, and delete student information.

The service follows common REST API best practices and the principles of the Twelve-Factor App methodology.

## Features (not implemented yet)

* Add a new student
* Get all students
* Get a student by ID
* Update student information
* Delete a student record
* Health check endpoint

## API Base Path

```
/api/v1/students
```

## API Endpoints

| Method | Endpoint              | Description                 |
| ------ | --------------------- | --------------------------- |
| POST   | /api/v1/students      | Create a new student        |
| GET    | /api/v1/students      | Retrieve all students       |
| GET    | /api/v1/students/{id} | Retrieve a specific student |
| PUT    | /api/v1/students/{id} | Update a student            |
| DELETE | /api/v1/students/{id} | Delete a student            |
| GET    | /healthcheck          | Service health status       |

## Tech Stack

* Language: Kotlin
* Framework: Micronaut
* Database: PostgreSQL
* Migrations: Flyway
* Build Tool: Gradle
* Testing: JUnit

## Environment Variables

Configuration values are provided through environment variables.

Example:

```
DB_HOST
DB_PORT
DB_NAME
DB_USER
DB_PASSWORD
```

## Running the Application (Planned)

```
make db
make run
```

## Testing (Planned)

```
make test
```

## Repository Goals

This project demonstrates:

* REST API best practices
* API versioning
* Database migrations
* Environment based configuration
* Logging and health checks
* Unit testing
