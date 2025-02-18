FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/config-service-0.0.1-SNAPSHOT.jar /app/config-service.jar
EXPOSE 8766
ENTRYPOINT ["java", "-jar", "/app/config-service.jar"]