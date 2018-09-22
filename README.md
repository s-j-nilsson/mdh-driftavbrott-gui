För att köra i docker

1. docker run -d -p 27000:27017 --name mongo mongo

2. docker build -t driftavbrott-gui:latest .

3. docker run -p 8080:8080 --name driftavbrott-gui --link=mongo  driftavbrott-gui



För att köra i IDE, t.ex. Intellij

1. Main class: MdhDriftavbrottGuiApplication

2. -Dspring.profiles.active=non-docker
