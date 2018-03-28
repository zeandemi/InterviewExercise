# Restful-booker-report

Report is responsible for collating information about the different hotels and the total price each hotel has across the hotels bookings.

## Building

To build this API run ```mvn clean package``` this will run the tests and then create a .JAR file that can be run.

## Running

To run the API, ensure that you have first built it and then run ```java -jar target/restful-booker-platform-report-1.0-SNAPSHOT.jar```. This will start up the API, allowing you to access it's endpoints.

## Documentation

To access this API's endpoint documentation, head to ```http://localhost:3005/swagger-ui.html```. You can also find out the health of the application by accessing ```http://localhost:3005/health```. Finally to access the APIs logfiles, head to ```http://localhost:3005/logfile```