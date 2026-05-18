FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Kopiujemy plik JAR (pamiętaj, aby wcześniej zrobić 'mvn package')
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]