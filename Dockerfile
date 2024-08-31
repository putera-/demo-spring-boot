# Build stage
FROM openjdk:22-jdk-slim AS build
WORKDIR /app
COPY . .
RUN ./gradlew build -x test

# Use an official OpenJDK runtime as a parent image
FROM openjdk:22-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY --from=build /app/build/libs/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app/app.jar"]
