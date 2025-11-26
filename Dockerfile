FROM openjdk:17
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/password-generator-app-1.0.0.jar"]