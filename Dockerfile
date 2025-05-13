FROM openjdk:21-ea-1-jdk-slim AS build
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y maven
RUN mvn clean install -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/nexo-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]