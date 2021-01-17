FROM maven:3.6.3-openjdk-11-slim AS MAVEN_BUILD
COPY ./ /opt/source
RUN mvn clean package -f /opt/source/pom.xml
FROM openjdk:11-jre-slim
COPY src/main/resources/UnlimitedJCEPolicyJDK8/*.jar /usr/lib/jvm/java-11-openjdk/jre/lib/security/
COPY --from=MAVEN_BUILD /opt/source/target/*.jar /opt/app.jar
ENTRYPOINT ["/usr/local/openjdk-11/bin/java"]
CMD ["-jar", "/opt/app.jar"]
EXPOSE 8080
