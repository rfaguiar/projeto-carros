FROM openjdk:8-jdk-alpine
MAINTAINER Rogerio Aguiar
ADD target/carros-api-0.0.1-SNAPSHOT.jar carros-api.jar
ENTRYPOINT [ "sh", "-c", "java -jar /carros-api.jar" ]