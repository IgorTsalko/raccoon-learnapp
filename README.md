# Home project - Raccoon learn app
Simple application for additional learning technologies I'm interested in.

### Description
Web application for learning words and phrases in English. Microservices architecture is used. For backend part is used - RESTful API.

What are used:

* Java 11
* Spring Boot
* Spring Data JPA
* Lombok
* MapStruct
* Docker

### App launch tips
To start one of the microservices via CMD you have to build and publishToMavenLocal all dependencies (like 'common') then build a microservice, or you can use 'servicePreparation' task. Then run command 'java -jar {microservice-name}/build/libs/{jar-file-name}.jar'. To stop a microservice use 'Ctrl + C'.
CMD command example:
* java -jar user-service/build/libs/user-service-0.0.1-SNAPSHOT.jar
* java -jar auth-service/build/libs/auth-service-0.0.1-SNAPSHOT.jar