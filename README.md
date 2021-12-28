# selenium-capability-test
This is a test for Selenium 4 to show slow remote webdriver creation.

Test with Selenium 4.1:

    1. docker-compose up -d 
    2. mvn test

Test with Selenium 3.1:
    
    1. docker-compose -f docker-compose-3.1.yml up -d
    2. mvn test

Docker-compose up -d will create a Selenium 4 Hub and one Chrome nodes (v94.0).
The maven test will use the RemoteWebDriver to create a Chrome session.
The test will make 5 iterations, each iteration will create a new session.
On my computer the test takes about 5-7 seconds per iteration.

Running the same test with selenium 3 will take about 1-2 seconds per iteration.
