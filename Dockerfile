# Stage 1: Build the project using Maven
FROM maven:3.9.9-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application with Amazon Corretto (OpenJDK 17)
FROM amazoncorretto:17
WORKDIR /app

COPY --from=build /app/target/JavaMavenProjectCal-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]