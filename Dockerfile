FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/lib/FizzBuzzSolution-0.1-SNAPSHOT.jar

# environment variable with default value
ENV INPUT = 100

COPY ${JAR_FILE} /opt/lib/FizzBuzzSolution-0.1-SNAPSHOT.jar

EXPOSE 80

#run with environment variable
ENTRYPOINT ["java","-jar","/opt/lib/FizzBuzzSolution-0.1-SNAPSHOT.jar", "${INPUT}"]