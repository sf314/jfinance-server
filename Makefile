

all: clean
	gradle build

clean:
	gradle clean 

run: 
	docker-compose up --build 