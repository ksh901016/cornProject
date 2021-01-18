# 런타임에서 사용될 리눅스 도커 이미지
FROM openjdk:8-jdk-alpine
RUN mkdir -p /usr/local/apiservice
ADD api-1.0-SNAPSHOT.jar /usr/local/apiservice/
ENTRYPOINT ["java", "-jar", "/usr/local/apiservice/api-1.0-SNAPSHOT.jar"]
