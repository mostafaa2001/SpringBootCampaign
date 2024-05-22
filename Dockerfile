FROM openjdk:22-ea-jdk

ARG JAR_FILE=target/*.jar

# Copy the built application JAR file to the container
COPY ${JAR_FILE} app.jar

# Define the entry point for the container with preview features enabled
ENTRYPOINT ["java", "-jar", "/app.jar"]
