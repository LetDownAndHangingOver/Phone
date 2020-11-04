FROM openjdk:8
ADD target/produit-docker.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/app.jar"]