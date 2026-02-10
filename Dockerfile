# 1. Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2. Run Stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# CHANGED: Added "-Xmx400m" to allow Java to use up to 400MB of RAM for the Heap.
# This fits within a 512MB container while leaving room for the OS.
ENTRYPOINT ["java", "-Xmx400m", "-jar", "app.jar"]