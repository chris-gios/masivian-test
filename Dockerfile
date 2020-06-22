FROM openjdk:8-jdk-alpine

VOLUME /tmp
RUN adduser --disabled-password --gecos '' app
WORKDIR /home/app

COPY ./build/libs/*.jar /home/app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/app/app.jar"]