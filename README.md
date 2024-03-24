
# Getting Started

### Description
This is a proof-of-concept SpringBoot app demonstrating various technologies and features, among others: 
  - how to use SpringCloud OpenFeign to build a declarative REST client
  - how to use OpenApi specification to describe HTTPS services and generate both client-side and server-side code
  - how to use Lombok to eliminate boilerplate code
  - how to use Mockito to write tests using mock beans in a SpringBoot app

Please note the integration tests are provided for demonstrative purposes only and may fail to run successfully, as the application depends on external service "Official Jokes Service", which returns data in inconsistent format. 

### Run

Use `mvn spring-boot:run`to run the application and `mvn test` to execute the tests. 

