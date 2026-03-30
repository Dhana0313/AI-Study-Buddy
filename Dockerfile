# 1. Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2. Run Stage (Explicitly using Jammy for stable apt-get servers)
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Install C++ math libraries required by PyTorch & Spring AI
RUN apt-get update && apt-get install -y libgomp1 ca-certificates

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Restrict RAM usage to prevent OOM kills
ENTRYPOINT ["java", "-Xmx400m", "-jar", "app.jar"]
