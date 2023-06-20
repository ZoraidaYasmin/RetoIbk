FROM openjdk:8-jre-alpine3.9
COPY ./target/retoIbk-0.0.1-SNAPSHOT.jar retoibk.jar
CMD ["java", "-jar", "retoibk.jar"]