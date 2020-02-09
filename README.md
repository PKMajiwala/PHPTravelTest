# PHPTravelTest
POC For Axelerant

**Pre-requisites for the project:**
1. Java 8+
2. Maven Installed with Path Variable (For Info: [Maven Installisation](https://www.javatpoint.com/how-to-install-maven))
3. [Windows] Chrome 80 Installed (If not than change driver as per chrome version in test resources folder) `If you are using linux than also you need to change driver`

**To Run the Project**
1. Move to project directory
2. Trigger Following Command:
> mvn -Dtest=*Runner test

**Project Structure**
```
.
+-- pom.xml
+-- testng.xml
+-- src
|   +-- test
|       +-- java
|           +-- StepDefs.java
|           +-- LoginRunner.java
|           +-- FlightSearchRunner.java
|           +-- NewsLetterRunner.java
|       +-- resources
|           +-- chromedriver.exe
|           +-- phptravel_featured_travel.feature
|           +-- phptravel_flight_search.feature
|           +-- phptravel_login.feature
|           +-- phptravel_newsletter_subscription.feature
```

***Note:*** Unable to complete featured travel feature as it disappeared suddenly
