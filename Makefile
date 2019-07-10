

all: clean
	gradle build

clean:
	gradle clean 

run: 
	docker-compose up --build 

run-local:
	java -jar build/libs/gs-rest-service-0.1.0.jar