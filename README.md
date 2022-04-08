Landscape of MicroProfile and Jakarta EE tools demo (April 2022)

Part 1: Creating the REST service 
Project creation: Use Open Liberty starter to create Open Liberty project with MP 5 and Jakarta EE 9, maven
rest-service project
show starting this application in dev mode with the Open Liberty Tools VS Code ext

Part 2: Creating the REST Client
Development/Deploy: Connect two different microservices with Open Liberty, REST Client Service Controller and REST Client 
Use EE8 and MP4 as tools are not up to date with the latest yet
use MP Starter in VS Code to generate a rest-client project with Gradle and Liberty - change ports to 9081 and 9444 in server.xml
use Generator for MP Rest Client VS Code ext to generate models and apis folder

Part 3: Testing
for the Open Liberty application, IntelliJ
Write an integration test with junit, show dev mode hot testing
Write an integration test with plain testcontainers
