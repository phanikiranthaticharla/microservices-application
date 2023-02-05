# SpringBoot Microservices Application
This is a SpringBoot microservices application written in Java 8 and built using Maven. The application consists of three main components:

- Citizen Microservice
- Vaccination Center Microservice
- Eureka Server

## Citizen Microservice
This microservice is responsible for adding new citizens to a vaccination center and retrieving details of all citizens within a vaccination center based on ID.

Features:

- Add a new citizen to a vaccination center
- Retrieve details of all citizens within a vaccination center based on ID

## Vaccination Center Microservice
This microservice is responsible for creating new vaccination centers and obtaining details of a vaccination center based on ID or name. This microservice connects to the Citizen Microservice to retrieve details of all citizens at a particular vaccination center.

Features:

- Create a new vaccination center
- Retrieve details of a vaccination center based on ID or name

## Eureka Server
Eureka Server is used for service discovery in this microservices application. It acts as a registry for all microservices and provides a centralized mechanism for service discovery.

## Running the Application
To run the application, follow these steps:

- Clone the repository to your local machine
Navigate to the root directory of the application
- Run the following command to build the application:
`mvn clean install`
- Start the Eureka Server by running the following command:
`java -jar eureka-server.jar`
- Start the Citizen Microservice and Vaccination Center Microservice by running the following command:
scss
`java -jar citizen-microservice.jar
java -jar vaccination-center-microservice.jar`

- Access the microservices through the API endpoint or via the Eureka Server UI at http://localhost:8761

## Conclusion
This is a simple example of a microservices application built using SpringBoot and Java 8 with Maven. The application demonstrates the use of service discovery using Eureka Server and how microservices can communicate with each other to provide a complete solution.
