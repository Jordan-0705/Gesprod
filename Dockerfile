# Étape 1 : Builder avec Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Exécuter l'application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copier le JAR final (nom forcé par <finalName>)
COPY --from=build /app/target/gesprod.jar app.jar

# Variables d'environnement pour Neon PostgreSQL
ENV DB_URL="jdbc:postgresql://ep-polished-mode-a4knhidj-pooler.us-east-1.aws.neon.tech/neondb?sslmode=require"
ENV DB_USER="neondb_owner"
ENV DB_PASSWORD="npg_JPs13CwuDctF"

# Lancer l'application
CMD ["java", "-jar", "app.jar"]
