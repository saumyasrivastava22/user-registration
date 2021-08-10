FROM openjdk:8
ADD build/libs/user-registration-0.0.1-SNAPSHOT.jar user-registration-0.0.1-SNAPSHOT.jar
EXPOSE 9876
ENTRYPOINT ["java", "-jar", "user-registration-0.0.1-SNAPSHOT.jar"]