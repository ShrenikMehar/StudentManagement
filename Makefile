build:
	./gradlew build

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew ktlintCheck detekt

format:
	./gradlew ktlintFormat

db-up:
	docker-compose up -d

db-down:
	docker-compose down
