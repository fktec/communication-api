FROM maven:3.3-jdk-8

USER root

LABEL description="Communication API" \
      version="1.0"

COPY . /usr/src/app
WORKDIR /usr/src/app

RUN mvn clean install

WORKDIR /usr/src/app/target

ENTRYPOINT ["java", "-jar", "communication-api-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
