FROM openjdk:8-jdk-alpine
ADD target/health-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTs=""
ENTRYPOINT ["java","-jar","/app.jar"]