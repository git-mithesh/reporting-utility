FROM openjdk:8
ADD target/docker-spring-boot.jar /var/lib/jenkins/workspace/reporting-utility/target/encrypt-decrypt-0.0.1-SNAPSHOT.jar
EXPOSE 8585
ENTRYPOINT ["java","-jar","reporting-utility.jar"]
