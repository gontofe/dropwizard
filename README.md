# dropwizard
## Summary
Dropwizard tutorial project based on https://www.baeldung.com/java-dropwizard

## Description
Creates a default list of brands which are available on the following endpoints:

### brands
GET http://localhost:8080/brands - list all brands

GET http://localhost:8080/brands/{id} - get an individual brand by ID

### health
There is also a rudimentary health endpoint implemented at http://localhost:8081/healthcheck

## Build

This project is built using Maven, and includes a Maven wrapper. To start a build:

`./mvn clean install`

## Run

To run:

`java -jar target/dropwizard-tutorial-1.0-SNAPSHOT.jar`