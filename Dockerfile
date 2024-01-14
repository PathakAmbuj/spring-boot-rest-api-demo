FROM openjdk:11
ADD ./target/spring-boot-rest-api-demo-0.0.1-SNAPSHOT.jar spring-boot-rest-api-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-rest-api-demo-0.0.1-SNAPSHOT.jar"]