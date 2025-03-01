# Stage 1: Build the project using Maven
FROM maven:3.9.9-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM amazoncorretto:17
WORKDIR /app

# Copy the JAR with the correct name
COPY --from=build /app/target/SPE_Mini_Project-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

# Use the simplified JAR name
ENTRYPOINT ["java", "-jar", "app.jar"]