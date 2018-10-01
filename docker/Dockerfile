FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD mdh-driftavbrott-gui-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongocontainer/driftavbrott", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

