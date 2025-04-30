FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/product-service-0.0.1-SNAPSHOT.jar /app/product-service.jar
EXPOSE 8764

ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]