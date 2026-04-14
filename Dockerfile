FROM eclipse-temurin:21
LABEL maintainer="ahmod"
COPY build/libs/computation-0.0.1-SNAPSHOT.jar computation.jar
ENTRYPOINT ["java", "-jar", "computation.jar"]
