FROM openjdk:8-jdk-alpine
MAINTAINER kuldeep singh
ARG JAR_FILE=build/libs/fizzbuzz-0.0.1-SNAPSHOT.jar

# environment variable with default value
ENV INPUT = 100

COPY ${JAR_FILE} /opt/libs/fizzbuzz-0.0.1-SNAPSHOT.jar

EXPOSE 80

#run with environment variable
ENTRYPOINT ["java","-jar","/opt/libs/fizzbuzz-0.0.1-SNAPSHOT.jar"]