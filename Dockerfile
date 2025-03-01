# Stage 1: Build the project using Maven
FROM maven:3.8.6-jdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application with Amazon Corretto (OpenJDK 17)
FROM amazoncorretto:17
WORKDIR /app

# Copy the generated JAR file from the builder stage
COPY --from=builder /app/target/*-jar-with-dependencies.jar /app/SPE_Mini_Project-0.0.1-SNAPSHOT.jar

# Make sure the entry point uses the correct JAR name
ENTRYPOINT ["java", "-jar", "SPE_Mini_Project-0.0.1-SNAPSHOT.jar"]
