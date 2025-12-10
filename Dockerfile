# Étape 1 : Image Maven pour compiler le projet
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier le pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le reste du projet
COPY src ./src

# Compiler et créer le jar "shaded" (avec toutes les dépendances)
RUN mvn clean package -DskipTests

# Étape 2 : Image JDK pour exécuter le jar
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copier le jar compilé depuis l'étape build
COPY --from=build /app/target/gesprod-1.0-SNAPSHOT-shaded.jar app.jar

# Exposer un port (si ton app a un serveur web, sinon ignore)
EXPOSE 8080

# Lancer l'application
CMD ["java", "-jar", "app.jar"]
