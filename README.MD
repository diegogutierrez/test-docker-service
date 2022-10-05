

- build

docker build --build-arg JAR_FILE=build/libs/test-service-0.0.1-SNAPSHOT.jar -t diego23/test-service:1.0 .


- run

docker run -p 8080:8080 diego23/test-service:1.0
