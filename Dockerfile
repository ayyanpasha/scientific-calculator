# Stage 1: Build the project using Maven
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
WORKDIR /app
COPY --from=builder /app/target/*-jar-with-dependencies.jar /app/SPE_Mini_Project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "calculator.jar"]