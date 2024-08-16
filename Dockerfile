FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /target/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]