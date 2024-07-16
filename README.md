#build the application
mvn clean install

#run the application
java -jar target/test-0.0.1-SNAPSHOT.jar

run junit test
mvn test

#code coverage report
mvn jacoco:report
