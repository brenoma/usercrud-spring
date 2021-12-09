FROM openjdk:11

MAINTAINER Breno Araripe

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

COPY . /app

WORKDIR /app

COPY target/userCrud*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app//userCrud*.jar"]

SHELL ["/bin/sh", "-c"]

CMD ["cd", "/app"]

CMD ["ls", "-la"]

# CMD java ${ADDITIONAL_OPTS} -jar /app/build/libs/userCrud-0.1.0.jar --spring.profiles.active=${PROFILE}