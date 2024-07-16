#build the application
mvn clean install

#run the application
java -jar target/<your-application-name>.jar

run junit test
mvn test

#code coverage report
mvn jacoco:report
