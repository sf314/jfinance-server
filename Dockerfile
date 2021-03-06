FROM gradle:latest
RUN echo "Executing Dockerfile"
COPY . /home/gradle/jfinance
EXPOSE 8080 8080
WORKDIR /home/gradle/jfinance
RUN gradle build
CMD java -jar build/libs/gs-rest-service-0.1.0.jar
# Sets default command of container to run the java exec after building