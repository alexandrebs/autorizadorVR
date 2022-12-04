FROM openjdk:11

ARG  PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring-boot

copy /target/spring-boot*.jar autorizadorVR

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar autorizadorVR.jar --spring.profiles.active=${PROFILE}