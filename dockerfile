# Usamos imagen de maven
FROM maven:3.8.4-openjdk-17 AS build

# Establecemos directorio de trabajo
WORKDIR /app

# Copiamos el proyecto al contenedor
COPY . ./

# Compilamos el proyecto y creamos jar
RUN mvn clean package -DskipTests

# Usamos imagen de java 17
FROM openjdk:17-jdk-slim

# Establecemos directorio de trabajo
WORKDIR /app

# Copiamos el jar generado en build
COPY --from=build /app/target/hola-luz-test-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Ejecutamos jar como comando de inicio
CMD ["java", "-jar", "app.jar"]
