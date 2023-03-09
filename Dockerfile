FROM maven:3.8.7-eclipse-temurin-17-alpine

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package
ENV PORT 8080
EXPOSE $PORT
CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]
