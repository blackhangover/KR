FROM openjdk:15
COPY build/libs/shelter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80:80
CMD ["java","-jar","app.jar"]