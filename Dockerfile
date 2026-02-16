FROM eclipse-temurin:17
EXPOSE 12000
ADD target/test-docker-0.0.1-SNAPSHOT.jar test-docker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/test-docker-0.0.1-SNAPSHOT.jar"]