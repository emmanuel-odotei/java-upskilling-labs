FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/order-service-0.0.1-SNAPSHOT.jar /app/order-service.jar
EXPOSE 8765

ENTRYPOINT ["java", "-jar", "/app/order-service.jar"]