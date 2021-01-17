FROM alpine:edge
MAINTAINER @chandanv89
RUN apk add --no-cache openjdk11
COPY src/main/resources/UnlimitedJCEPolicyJDK8/*.jar /usr/lib/jvm/java-11-openjdk/jre/lib/security/
COPY target/hateoas-example-0.0.1.jar /opt/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/hateoas-example-0.0.1.jar"]
EXPOSE 8080
