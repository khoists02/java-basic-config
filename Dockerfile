FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/docker-message-server-0.1.0.jar parent-0.1.0.jar
ENTRYPOINT ["java","-jar","/parent-1.0.0.jar"]