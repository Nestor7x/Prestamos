# Etapa 1: Compilacion y empaquetado
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Cache de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B || true

# Copiar codigo fuente y construir jar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final de ejecucion (liviana)
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiar artefacto compilado
COPY --from=build /app/target/*.jar app.jar

# Render asigna dinamicamente la variable PORT (por defecto 8080)
ENV PORT=8080
EXPOSE 8080

# Parametros optimizados para la memoria de Render (512 MB en free tier)
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -jar app.jar"]
