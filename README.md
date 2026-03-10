# Student REST API

## Overview

This project implements a simple REST API to manage student records.

The API allows clients to create, retrieve, update, and delete student information.
The service is implemented using Kotlin and the Micronaut framework and follows common REST API best practices along with principles inspired by the Twelve-Factor App methodology.

The project also demonstrates good backend engineering practices such as:

* automated formatting and linting
* unit testing
* CI validation
* structured logging
* Git hooks for local quality checks

---

## Features

The API currently supports the following operations:

* Add a new student
* Get all students
* Get a student by ID
* Update student information
* Delete a student record
* Health check endpoint

Students are currently stored using an **in-memory data store**.
A database layer will be introduced in a later milestone.

---

## API Base Path

```
/api/v1/students
```

---

## API Endpoints

| Method | Endpoint              | Description                 |
| ------ | --------------------- | --------------------------- |
| POST   | /api/v1/students      | Create a new student        |
| GET    | /api/v1/students      | Retrieve all students       |
| GET    | /api/v1/students/{id} | Retrieve a specific student |
| PUT    | /api/v1/students/{id} | Update a student            |
| DELETE | /api/v1/students/{id} | Delete a student            |
| GET    | /healthcheck          | Service health status       |

---

## Tech Stack

* **Language:** Kotlin
* **Framework:** Micronaut
* **Build Tool:** Gradle
* **Testing:** JUnit 5
* **Logging:** Logback
* **Linting:** Detekt
* **Formatting:** ktlint
* **CI:** GitHub Actions

---

## Code Quality

This project enforces code quality using the following tools:

### Static Analysis

Detekt is used for Kotlin static analysis.

Run manually:

```
./gradlew detekt
```

---

### Code Formatting

ktlint automatically enforces Kotlin code formatting.

Check formatting:

```
./gradlew ktlintCheck
```

Automatically fix formatting:

```
./gradlew ktlintFormat
```

---

## Git Hooks

Local Git hooks are used to ensure code quality before commits and pushes.

Hooks perform the following checks:

### Pre-commit

* Run ktlint formatter
* Run detekt lint checks

### Pre-push

* Run unit tests

To install hooks after cloning the repository:

```
./scripts/setup-git-hooks.sh
```

---

## Continuous Integration

A CI pipeline is configured using GitHub Actions.

Every push and pull request automatically runs:

* project build
* static analysis (Detekt)
* formatting checks (ktlint)
* unit tests

---

## Prerequisites

The following tools must be installed before running the project locally.

### Java

This project requires **Java 21**.

Check your installed version:

```
java -version
```

Example expected output:

```
openjdk version "21.x"
```

The Gradle build is configured to use the **Java 21 toolchain**.

---

### Git

Git is required to clone the repository and enable the provided Git hooks.

```
git --version
```

---

### Gradle

No manual installation is required.

The project uses the **Gradle Wrapper**, so all build commands can be executed using:

```
./gradlew <task>
```

---

## Running the Application

Run the service locally:

```
./gradlew run
```

The API will start on the default Micronaut port.

---

## Running Tests

Execute the test suite using:

```
./gradlew test
```

---

## Project Structure

```
src/main/kotlin    → application source code
src/test/kotlin    → unit tests
.githooks          → git hooks (pre-commit, pre-push)
scripts            → developer setup scripts
```

---

## Planned Improvements

The following features will be added in future milestones:

* PostgreSQL database integration
* Flyway database migrations
* Repository layer
* environment based configuration
* OpenAPI / Swagger documentation
* Makefile for common development tasks
* API request validation
* pagination support
* Docker support
