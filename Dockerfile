#FROM gradle:7.4.1-jdk17 AS build
#RUN mkdir /usr/src/project
#COPY . /usr/src/project
#WORKDIR /usr/src/project
#RUN gradle clean bootJar
#
#
#FROM openjdk:17-alpine
#RUN mkdir /project
#COPY --from=build /usr/src/project/build/libs/bookt-0.0.1-SNAPSHOT.jar /project/
#WORKDIR /project
##ADD /build/libs/bookt-0.0.1-SNAPSHOT.jar bookt.jar
#CMD java -jar bookt-0.0.1-SNAPSHOT.jar
##ENTRYPOINT ["java", "-jar", "bookt.jar"]



FROM openjdk:17-alpine
RUN mkdir /project
COPY /build/libs/bookt-0.0.1-SNAPSHOT.jar /project/
WORKDIR /project
#ADD /build/libs/bookt-0.0.1-SNAPSHOT.jar bookt.jar
CMD java -jar bookt-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "bookt.jar"]