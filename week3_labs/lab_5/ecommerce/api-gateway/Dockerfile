FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar
EXPOSE 8768

ENTRYPOINT ["java", "-jar", "/app/api-gateway.jar"]