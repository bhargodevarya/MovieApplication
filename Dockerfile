#FROM openjdk:11
FROM azul/zulu-openjdk:11.0.24-jdk
#passed while building image, not a proper way
#ARG mongo_username
#ARG mongo_password

WORKDIR /apps

COPY ./build/libs/MovieApplication*.jar MovieApplication.jar

#ENV MONGO_USERNAME=$mongo_username
#ENV MONGO_PASSWORD=$mongo_password

EXPOSE 8080

CMD ["java", "-jar", "MovieApplication.jar"]