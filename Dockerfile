FROM maven:3.8.4-eclipse-temurin-17-alpine AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/crypto-dashboard-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17-alpine3.12
COPY --from=MAVEN_BUILD /target/crypto-dashboard-0.0.1-SNAPSHOT.jar /crypto-dashboard.jar
CMD ["java", "-jar", "/crypto-dashboard.jar"]