FROM openjdk:17-alpine

WORKDIR /app

COPY build/libs/*.jar y-taxi.jar

ENTRYPOINT ["java", "-jar", "y-taxi.jar"]
