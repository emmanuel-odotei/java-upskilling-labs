FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/registry-server-0.0.1-SNAPSHOT.jar /app/registry-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/registry-server.jar"]