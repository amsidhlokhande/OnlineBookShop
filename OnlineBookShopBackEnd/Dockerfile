FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1
VOLUME ["/tmp"]
COPY target/OnlineBookShopBackEnd-*.jar OnlineBookShopBackEnd.jar
COPY src/ src
COPY pom.xml pom.xml
COPY Dockerfile Dockerfile
ENTRYPOINT ["java","-jar","OnlineBookShopBackEnd.jar"]