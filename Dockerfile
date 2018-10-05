FROM maven:3-alpine

VOLUME /tmp

ADD /target/App_Demo-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
