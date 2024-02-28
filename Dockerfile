# Use uma imagem base com a JVM
FROM openjdk:17-alpine

# Copie o jar da sua aplicação para a imagem
COPY target/product-microservice-0.0.1-SNAPSHOT.jar /app/product-microservice-0.0.1-SNAPSHOT.jar

# Defina o diretório de trabalho como /app
WORKDIR /app

# Exponha a porta 8080
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "product-microservice-0.0.1-SNAPSHOT.jar"]