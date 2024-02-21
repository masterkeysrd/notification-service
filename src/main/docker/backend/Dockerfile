# Create dockerfile to build the backend
FROM eclipse-temurin:17-jdk-jammy AS BUILDER
WORKDIR /app
COPY ./build.gradle ./settings.gradle ./gradlew ./
COPY gradle ./gradle
RUN ./gradlew --version
COPY ./src/main/java ./src/main/java
COPY ./src/main/resources ./src/main/resources
RUN ./gradlew build

# Create dockerfile to run the backend
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=BUILDER /app/build/libs/*.jar ./app.jar
CMD ["java", "-jar", "app.jar"]