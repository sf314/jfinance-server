

all: clean
	gradle build

clean:
	gradle clean 

run: 
	docker-compose up --build 

run-local:
	java -jar build/libs/jfinance-rest-service-0.0.0.jar