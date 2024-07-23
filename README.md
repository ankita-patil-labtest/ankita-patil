
# Retail Discount Billing System
This project is a Java Spring Boot application that calculates the net payable amount for a bill on a retail website, applying various discounts based on user types and bill conditions.

Requirements
* Clone this repository 
* Make sure you are using JDK 17 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
* If the user is an employee of the store, they get a 30% discount.
* If the user is an affiliate of the store, they get a 10% discount.
* If the user has been a customer for over 2 years, they get a 5% discount.
* For every $100 on the bill, there is a $5 discount.
* Percentage-based discounts do not apply on groceries.
* A user can only receive one of the percentage-based discounts on a bill.

# Implementation Details

# Project Structure
The project is structured as follows:

* src/main/java: Contains the Java source code.
* src/test/java: Contains unit test cases.
* pom.xml: Maven configuration file for dependencies and build settings.

# Class Diagram
* DiscountCalculatorService: Handles various discount calculation rules based on user type and bill conditions.
* User: Represents the user with attributes like user type and tenure.
* Order: Represents the order details.
* OrderNotFountException: Represents the Custom exception to handle failure scenario.

# Dependencies
* Java 17
* Spring Boot 3.x
* JUnit 5 for unit testing
* Mockito for mocking dependencies

# How to Run

1. Build the project:
```
mvn clean install
```

2. Run the tests:
```
mvn test
```

3. Test Coverage
Test coverage reports can be generated using JaCoCo plugin for Maven.
To generate the coverage report:
```
mvn clean test jacoco:report
```
