FROM openjdk:8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/* ./demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]