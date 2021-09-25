# syntax=docker/dockerfile:1

FROM openjdk:17-alpine3.14 as base

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src

FROM base as test
RUN ["./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run"]

FROM base as build
RUN ./mvnw package


FROM tomcat:10.1.0-jdk17-openjdk as production-stage
LABEL maintainer="nicolas.noseda.pro@gmail.com"
COPY --from=build /app/target/dockerSpring*.war /usr/local/tomcat/webapps/dockerSpring.war
EXPOSE 8080
CMD ["catalina.sh", "run"]

