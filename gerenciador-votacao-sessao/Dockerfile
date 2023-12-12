FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
ENV DOCKERIZE_VERSION v0.6.1
RUN apt-get update && apt-get install -y wget \
    && wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/*.jar app.jar
CMD ["dockerize", "-wait", "tcp://postgres:5432", "-timeout", "20s", "java", "-jar", "app.jar"]

EXPOSE 9080
