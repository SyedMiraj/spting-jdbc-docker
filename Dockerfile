FROM openjdk:8
WORKDIR /src/java
ADD target/*.jar jdbc-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jdbc-docker.jar"]