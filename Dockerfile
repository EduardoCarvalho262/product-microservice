# Use uma imagem base com a JVM
FROM maven:3.8.4-openjdk-17 AS build

# Copie o código-fonte e os arquivos de configuração
COPY pom.xml .
COPY src src

# Compile o projeto e empacote em um JAR usando Maven
RUN mvn clean install

# Use uma nova imagem base com a JVM
FROM openjdk:17-alpine

# Copie o JAR da sua aplicação para a imagem
COPY --from=build ./target/product-microservice-0.0.1-SNAPSHOT.jar /app/product-microservice-0.0.1-SNAPSHOT.jar

# Defina o diretório de trabalho como /app
WORKDIR /app

# Exponha a porta 8080
EXPOSE 8081

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "product-microservice-0.0.1-SNAPSHOT.jar"]
