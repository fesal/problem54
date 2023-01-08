#Problem 54 - Euler

This project provides the solution to the EULER problem nr. 54. Details can be found: https://projecteuler.net/problem=54.
In abstract manner the project follows Object Oriented Programming style following some design principles. 
- It follows Single Responsibility Principle by creating specific classes and how the classes can evolve.   
- Have introduced lombok which removes boiler plate code in the project
- Have introduced some custom Maps for current project to make it easy to extend and add new functionalities on the project
- Have made the methods as short as possible so they are unit tested
- From the testing perspective (Unit testing) it is introduced Builder patter so we can reuse data whenever there are more unit tests to be written 

The application works as following: read and parse the data from the file and create instances of objects and put them on custom Map implementation. Then iterate through the list and play the game by calling pokerHandsWinner. Then, via this method it is checked the ranking of the hand starting from the highest described in the problem (Royal Flush) until we find the appropriate hand from the cards. Then, comparison between two hands is made and the outcome is displayed. 

## Prerequisites

- Java 17
- Maven 3.8.1
  - Dependency: Lombok 1.18.24
  - Dependency for JUNIT 5 
    - jupiter-api
    - jupiter-engine
    
To install these dependencies you need to first setup maven and have installed Java 17 (including the environment variables JAVA_HOME and M2_HOME).

## Build and Run
Navigate to the root directory of the project you downloaded and run the following command to build the project

mvn package

To execute the project run the following command

java -jar target/Problem54-1.0-SNAPSHOT.jar


# Tests
 To run the JUNIT tests writen run the following command
 
 mvn test
