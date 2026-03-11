IMAGE_NAME=student-api
VERSION ?= 1.0.0

# Build docker image
build:
	docker build -t $(IMAGE_NAME):$(VERSION) .

# Run full system (API + Postgres)
run:
	docker-compose up

# Stop containers
stop:
	docker-compose down

# View logs
logs:
	docker-compose logs -f

# Run database only
db-up:
	docker-compose up -d postgres

db-down:
	docker-compose down


# ---- Local development helpers ----

local-build:
	./gradlew build

local-run:
	./gradlew run

local-test:
	./gradlew test

lint:
	./gradlew ktlintCheck detekt

format:
	./gradlew ktlintFormat
