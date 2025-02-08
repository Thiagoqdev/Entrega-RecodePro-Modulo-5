FROM openjdk:17-jdk-slim


WORKDIR /app


COPY target/ExploreDescubraMVC-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]