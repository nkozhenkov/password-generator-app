FROM openjdk:17-alpine
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/password-generator-app-0.0.1-SNAPSHOT.jar"]