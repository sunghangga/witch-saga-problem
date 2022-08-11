## Setup Application
####
Clone repository
```
git clone https://github.com/sunghangga/witch-saga-problem.git
```
####
Install Depedency using Maven. (Make sure [Maven](https://maven.apache.org/install.html) already installed on your machine before running this syntax).
```
mvn clean install
```
####
Run the program using your favorite IDE (IntelliJ IDEA or Eclipse)

## API Documentation
For API documentation, you can visit this [link](https://witch-saga-geekseat.herokuapp.com/swagger-ui/index.html).

## Test Application
####
Run all the unit test classes
```
mvn test
```
####
Run a single test class
```
mvn -Dtest=WitchSagaServiceTest test
```
####
Run multiple test classes
```
mvn -Dtest=WitchSagaServiceTest,WitchSagaControllerTest test
```
####
Run a single test method from a test class
```
mvn -Dtest=WitchSagaServiceTest#givenAverageMoreThan0_whenRequestValidParam_thenValueMoreThan0Received test
```

## Deploy Heroku
####
Package the project
```
mvn package
```
####
Install java plugin for heroku CLI
```
heroku plugins:install java
```
####
Create app and deploy to heroku
```
heroku create witch-saga-geekseat --no-remote
heroku deploy:jar target/witchsaga-0.0.1-SNAPSHOT.jar -a witch-saga-geekseat
```