# 런타임에서 사용될 리눅스 도커 이미지
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=@project.build.finalName@.jar
RUN mkdir -p /usr/local/apiservice
ADD $JAR_FILE /usr/local/apiservice/
ENTRYPOINT ["java", "-jar", "/usr/local/apiservice/$JAR_FILE"]
