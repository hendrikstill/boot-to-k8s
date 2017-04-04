FROM openjdk:8-jre-alpine
MAINTAINER Hendrik Still<hendrik.still@inovex.de>

ADD target/boot-to-k8s-service.jar /app/boot-to-k8s-service.jar

WORKDIR /app

EXPOSE 8080

CMD java -Xms128m -Xmx256m -jar /app/boot-to-k8s-service.jar

