# Fetching latest version of Java
FROM openjdk:17

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/gestShop-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-Dspring.profiles.active=mysql" ,"-jar", "gestShop-0.0.1-SNAPSHOT.jar"]