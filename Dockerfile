FROM openjdk:8
ADD target/docker-spring-boot.jar reporting-utility.jar
EXPOSE 8585
ENTRYPOINT ["java","-jar","reporting-utility.jar"]
