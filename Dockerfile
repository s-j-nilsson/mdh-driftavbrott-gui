FROM java:8
VOLUME /tmp
ADD target/mdh-driftavbrott-gui-0.0.1-SNAPSHOT.jar driftavbrott-gui.jar
EXPOSE 8080
RUN bash -c 'touch /driftavbrott-gui.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/driftavbrott-gui.jar"]

