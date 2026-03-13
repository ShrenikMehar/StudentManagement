# Student REST API

## Overview

This project implements a simple REST API to manage student records.

The API allows clients to create, retrieve, update, and delete student information.
The service is implemented using **Kotlin** and the **Micronaut** framework and follows REST API best practices along with principles inspired by the **Twelve-Factor App methodology**.

The project also demonstrates good backend engineering practices such as:

* automated formatting and linting
* unit testing
* CI validation
* structured logging
* Git hooks for local quality checks
* database migrations
* containerized deployment using Docker
* infrastructure provisioning using Vagrant

---

## Features

The API supports the following operations:

* Add a new student
* Get all students
* Get a student by ID
* Update student information
* Delete a student record
* Health check endpoint

Student data is stored in **PostgreSQL**, and schema management is handled using **Flyway migrations**.

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
* **Database:** PostgreSQL
* **Database Migration:** Flyway
* **Build Tool:** Gradle
* **Testing:** JUnit 5
* **Logging:** Logback
* **Linting:** Detekt
* **Formatting:** ktlint
* **CI:** GitHub Actions
* **Containerization:** Docker
* **Infrastructure:** Vagrant

---

## Docker Image Optimization

Different runtime base images were evaluated to reduce container size.

| Base Image                    | Image Size |
| ----------------------------- | ---------- |
| eclipse-temurin:21-jre        | ~473 MB    |
| eclipse-temurin:21-jre-jammy  | ~438 MB    |
| eclipse-temurin:21-jre-alpine | ~333 MB    |
| distroless/java21             | ~318 MB    |

The project uses:

```
eclipse-temurin:21-jre-alpine
```

This provides a good balance between **smaller image size**, **JVM compatibility**, and **ease of debugging** compared to minimal distroless images.

---

## Quick Start (Docker)

The easiest way to run the application is using Docker.
This starts both the **API** and the **PostgreSQL database**.

### Build the Docker image

```
make build
```

### Start the application

```
make run
```

This starts:

* PostgreSQL database
* Student REST API

The API will be available at:

```
http://localhost:8080
```

Health check endpoint:

```
http://localhost:8080/healthcheck
```

### Stop the application

```
make stop
```

### View logs

```
make logs
```

---

## Local Development (Optional)

If you want to run the API directly without Docker.

### Start PostgreSQL

```
make db-up
```

### Run the API locally

```
make local-run
```

The API will start at:

```
http://localhost:8080
```

### Stop PostgreSQL

```
make db-down
```

---

## Bare Metal Deployment (Vagrant)

The project can also be deployed inside a **virtual machine that simulates a production environment**.

This VM runs the application stack using **Docker containers**, similar to how services would run on a real server.

### Architecture

Current deployment architecture:

```
Client
   │
   ▼
Student API Container
   │
   ▼
PostgreSQL Container
```

Future stages introduce horizontal scaling and load balancing:

```
Client
   │
   ▼
Nginx Load Balancer
   │
   ├── Student API Instance 1
   └── Student API Instance 2
          │
          ▼
        PostgreSQL
```

---

## Infrastructure Layout

Infrastructure configuration is stored in the `infra` directory.

```
infra/
 ├── provision.sh
 ├── docker-compose.yml
 └── nginx/
     └── nginx.conf
```

The virtual machine configuration is defined in:

```
Vagrantfile
```

---

## Running the Application in the VM

### Start the VM

From the project root:

```
vagrant up
```

This will:

* create the VM
* install Docker inside the VM
* prepare the environment for container deployment

### SSH into the VM

```
vagrant ssh
```

### Deploy the containers

Inside the VM:

```
cd /vagrant/infra
docker-compose up -d
```

This starts:

* PostgreSQL container
* Student API container

### Verify the API

```
curl http://localhost:8080/healthcheck
```

Expected response:

```
OK
```

### Stop the containers

```
docker-compose down
```

### Stop the VM

From the host machine:

```
vagrant halt
```

---

## Apple Silicon (UTM) Support

This project was developed and tested on **Apple Silicon hardware (MacBook with M4 chip)**.

Traditional Vagrant setups typically use **VirtualBox** as the virtualization provider.
However, VirtualBox does **not support Apple Silicon processors**.

To run Vagrant VMs on Apple Silicon, this project uses:

```
UTM + vagrant_utm provider
```

UTM is built on **QEMU** and provides ARM-compatible virtualization for macOS.

---

## Installing Vagrant on Apple Silicon

### Install UTM

Download from:

```
https://mac.getutm.app/
```

---

### Install Vagrant

Using Homebrew:

```
brew install vagrant
```

Verify installation:

```
vagrant --version
```

---

### Install the UTM provider

```
vagrant plugin install vagrant_utm
```

Verify:

```
vagrant plugin list
```

Expected output:

```
vagrant_utm
```

---

## Supported VM Image

The project uses the following ARM-compatible Vagrant box:

```
utm/bookworm
```

This provides a **Debian 12 ARM64 environment** compatible with UTM.

---

## Tested Environment

This infrastructure setup has been tested on:

```
MacBook (Apple Silicon M4)
macOS
UTM
Vagrant
Docker running inside VM
```

---

## Running Tests

```
make local-test
```

---

## Code Quality

### Linting

Detekt is used for Kotlin static analysis.

```
make lint
```

### Formatting

ktlint automatically enforces Kotlin code formatting.

```
make format
```

---

## Git Hooks

Local Git hooks ensure code quality before commits and pushes.

### Pre-commit

* run ktlint formatter
* run detekt lint checks

### Pre-push

* run unit tests

Install hooks after cloning the repository:

```
./scripts/setup-git-hooks.sh
```

---

## Continuous Integration

A CI pipeline is configured using **GitHub Actions**.

Every push and pull request automatically runs:

* project build
* static analysis (Detekt)
* formatting checks (ktlint)
* unit tests
* Docker image build
* Docker image publishing

---

## Prerequisites

The easiest way to verify your development environment is to run:

```
./scripts/setup-prerequisites.sh
```

This script checks if required tools are installed.

### Docker

```
docker --version
```

### Make

```
make --version
```

### Java (Optional)

Java is only required when running the application without Docker.

The project uses **Java 21**.

```
java -version
```

---

## Postman Collection

A Postman collection is included for testing the API.

Location:

```
postman/student-api.postman_collection.json
```

### Import Steps

1. Open Postman
2. Click **Import**
3. Select the collection file

Ensure the API is running (`http://localhost:8080`) before sending requests.

---

## Project Structure

```
src/main/kotlin
  controller     → REST controllers
  service        → business logic
  repository     → database access
  entity         → database entities
  dto            → request/response models

src/main/resources
  db/migration   → Flyway database migrations

src/test/kotlin  → unit tests

.githooks        → git hooks (pre-commit, pre-push)

infra            → infrastructure configuration (Vagrant deployment)

scripts          → developer setup scripts
postman          → API testing collection
```

---

## Future Improvements

Possible enhancements for future iterations:

* API request validation
* pagination support
* API documentation (OpenAPI / Swagger)
* container registry publishing
* horizontal scaling with load balancing
