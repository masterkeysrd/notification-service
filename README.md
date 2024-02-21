# Notification Service

## About

This is a simple notification service that allows to fan out messages to multiple subscribers depending on the category of the message and the subscriber's channel.

## Requirements

- Java 17
- Gradle (optional, the project uses the Gradle Wrapper)
- Node.js
- Docker
- Docker Compose

## Running the application

The application can be run using Docker Compose. With the following setups:

- Running all services (backend, frontend, and database) in Docker
- Running backend locally (frontend and database in Docker)
- Running frontend locally (backend and database in Docker)
- Running backend and database locally (frontend in Docker)

### Running all services (backend, frontend, and database) in Docker

Run the following command to start all services:

```bash
docker compose -f ./src/main/docker/app.yml up --build -d # Start all services
```

> The backend will be available at <http://localhost:8080> and the frontend will be available at <http://localhost>

### Running backend locally (frontend and database in Docker)

Run the following command to start the backend and the database:

```bash
docker compose -f ./src/main/docker/webapp.yml up --build -d # Start the webapp and the database
./gradlew bootRun # Start the backend
```

> The backend will be available at <http://localhost:8080> and the frontend will be available at <http://localhost>

### Running frontend locally (backend and database in Docker)

Run the following command to start the backend and the database:

```bash
docker compose -f ./src/main/docker/backend.yml up --build -d # Start the backend and the database
npm run dev # Start the frontend
```

> The backend will be available at <http://localhost:8080> and the frontend will be available at <http://localhost:5173/>

### Running backend and database locally (frontend in Docker)

Run the following command to start the backend and the database:

```bash
docker compose -f ./src/main/docker/mongodb.yml up --build -d # Start the database
./gradlew bootRun # Start the backend
npm run dev # Start the frontend
```

> The backend will be available at <http://localhost:8080> and the frontend will be available at <http://localhost:5173/>
