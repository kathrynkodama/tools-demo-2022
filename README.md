# Landscape of MicroProfile and Jakarta EE tools demo (April 2022)

## Part 1: Creating the REST service 
1. Project creation: Use Open Liberty starter: https://start.microprofile.io/ to create Open Liberty project with MP 5 and Jakarta EE 9, Maven
2. Unzip the project into VS Code, start the application with `./mvnw liberty:dev`
3. Create the /rest-service[/rest-service] application (Cafe service)
Tooling used
- Open Liberty Starter
- Liberty dev mode
- Open Liberty Tools VS Code ext

## Part 2: Creating the REST Client and connecting to the REST service in Part 1
1. Project creation: MicroProfile starter to generate an Open Liberty project withMP 4.1 and Open Liberty - change the ports in the server.xml to 9081 and 9444 so they do not conflict with rest-service app
2. Create the /rest-client[/rest-client] application (Cafe controller) 
3. use Generator for MP Rest Client VS Code ext to generate models and apis folder

*Using EE8 and MP4 as tools are not up to date with the latest yet*

Tooling used:
- MicroProfile Starter
- Tools for MicroProfile (MicroProfile language server)
- Liberty dev mode
- Open Liberty Tools VS Code ext
- Generator for MicroProfile REST Client

## Part 3: Testing
 In /rest-service[/rest-service] application 
- Write an integration test with junit, show dev mode hot testing
- Stop dev mode
- Show how we can modify that test to use testcontainers
 - Package application to generate war.xml
 - build docker image with build -t 
 - Run with mvn:failsafe:integration-test

Tooling used:
- Liberty dev mode for containers
- Liberty dev mode hot testing
- Testcontainers
