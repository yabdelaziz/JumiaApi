FROM openjdk:11

VOLUME /src/main/resources
ADD /src/main/resources/sample.db  /src/main/resources/sample.db
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
