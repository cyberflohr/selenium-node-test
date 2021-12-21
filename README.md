# selenium-capability-test
This is a test for Selenium 4 to show, that desired capabilities (browser version) are not working as expected.

How to test:

    1. docker-compose up -d 
    2. mvn test

Docker-compose up -d will create a Selenium 4 Hub and two Chrome nodes (v96.0 and v94.0).
The maven test will use the RemoteWebDriver to create a Chrome session (v94.0).
Unfortunately, the Test fails multiple times, because the returned browser version is  
not equal to the requested browser version. Selenium is doing a round-robin for the chrome nodes,
instead of returning the requested version.
