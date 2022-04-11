Landscape of MicroProfile and Jakarta EE tools demo (April 2022)

Part 1: Creating the REST service 
Project creation: Use Open Liberty starter to create an Open Liberty project with MP 5 and Jakarta EE 9, maven
rest-service project
show starting this application in dev mode with the Open Liberty Tools VS Code ext

Part 2: Creating the REST Client
Development/Deploy: Connect the Open Liberty rest-serivce from part 1 to a Payara rest-client
Project creation: Use the MicroProfile Starter to create a Payara project with MP 4 and Jakarta EE 8

Use EE8 and MP4 as tools are not up to date (as of April 2022) with the latest yet
use Generator for MP Rest Client VS Code ext to generate models and apis folder

Part 3: Testing
for the Open Liberty application, IntelliJ
Write an integration test with junit, show dev mode hot testing
Write an integration test with plain testcontainers
