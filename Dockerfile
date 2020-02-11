FROM openjdk:8
ADD target/docker-reporting-utility.jar docker-reporting-utility.jar 
EXPOSE 8088
ENTRYPOINT ["java","-jar","docker-reporting-utility.jar"]
