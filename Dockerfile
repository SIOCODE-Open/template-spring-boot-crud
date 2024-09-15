FROM eclipse-temurin:17 AS build
WORKDIR /app
ADD ./gradlew /app/gradlew
ADD ./gradle/ /app/gradle/
RUN chmod +x gradlew && ./gradlew --version --no-daemon
ADD ./build.gradle.kts /app/build.gradle.kts
ADD ./settings.gradle.kts /app/settings.gradle.kts
ADD ./src/ /app/src/
RUN ./gradlew --no-daemon bootJar

FROM eclipse-temurin:17 AS run
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
COPY --from=build /app/src/main/resources/application.properties /app/application.properties
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]