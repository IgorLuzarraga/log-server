Log Server With RabbitMQ
==============

Spring Boot application that implements a Log Server.
Using RabbitMQ it is possible to send log messages from other
applications to this Server.
The GUI to visualize the logs is made with Vaadin framework.


Modules:
========
- Spring Boot
- Spring Data JPA
- Spring Boot Web 
- Vaadin - Java web framework - https://vaadin.com
- H2 In-Memory Database
- Spring Boot amqp
- RabbitMQ (https://www.rabbitmq.com/)

Build the jar:
-------------------------
./gradlew build

Run the jar:
-------------------------
java -jar build/libs/log-server-0.0.1-SNAPSHOT.jar

Test the application:
-------------------------
In order to receive the sended log messages when a CRUD operation 
is made, you need:
1. install RabbitMQ and start the service
2. start the Server Log (receives the log messages).
3. Download and Start the service that will send the logs.
See the other applications that use RabbitMQ in my repositories.

The project consists of two Http Serves:
1. http://localhost:8080/books - Restful web Service
2. http://localhost:8090 Log Server
RabbitMQ send the messages between these two servers.

Connect to the server via http://localhost:8080/books using
for example a Restful API tester, like Postman, to check the 
CRUD operations and check the logs sended to the other server
http://localhost:8090

Note: the json input for PUT or POST should be like:

{
	"author" : "book´s author",
	"title" : "book´s title"
}
