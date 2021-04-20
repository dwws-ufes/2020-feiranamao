#METODO 1
FROM maven AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
COPY src/main/resources/application.properties.prod  /workspace/src/main/resources/application.properties
RUN mvn -f pom.xml clean package

FROM openjdk:11
COPY --from=build /workspace/target/*.jar app.jar 
EXPOSE 8380
ENTRYPOINT ["java","-jar","app.jar"]

#METODO 2
#FROM openjdk:17
#COPY  target/*.jar app.jar 
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]
