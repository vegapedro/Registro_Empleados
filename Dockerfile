# Etapa 1: Construir la aplicación con Maven
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Construir la aplicación y generar el archivo JAR
# Se omiten los tests para acelerar el proceso de build
RUN mvn clean install -DskipTests

# Etapa 2: Crear la imagen final de ejecución
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","app.jar"]
