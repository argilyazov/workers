FROM adoptopenjdk/openjdk11:alpine-jre
LABEL authors="argilyazov"
ARG JAR_FILE=target/spring-docker-simple-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
