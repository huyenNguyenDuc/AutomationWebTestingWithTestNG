# AutomationWebTestingWithTestNG
Automation Web testing with Selenium, Cucumber and TestNG

Framework: Behavior Driven development (BDD) using Cucumber, Selenium, and TestNG
software project management: Maven.
Web testing: Web url = “https://askomdch.com”
Default browser: Chrome

The main structure of this project:

 1. Feature files: (stored in “src/test/resources/testSteps”)
The feature files contain all the scenario (test cases) which are wrote by Gherkin language.
 - addProductFromStore.feature and checkOutOrder.feature:
store the testing scenarios for Web url = “https://askomdch.com”
 - dataTableTest.feature: store all example of data table 

 2. Step definitions: (stored in “src/test/java/testSteps”)
 - Contains method (code) for each step in feature files

 3. Runner: (stored in “src/test/java/runner”)
 - Use TestNG framework
 - testng.xml (src/test/resources/testng.xml) controls running process for both TestNGRunnerTest.java and TestNGRunnerTesting.java 
 - Can run directly TestNGRunnerTest.java and TestNGRunnerTesting.java
 - Hooks.java: add external methods to run before and after each scenario

 4. Pages: (stored in “src/test/java/pages”)
 - Contains all actions and element locators on a page

 5. Pom.xml: (pom.xml)
 - Contains all plugins

 6. Report: (stored in “src/report”)
 - Stores all reports in HTML format after each running with testNG or maven command line 

 7. Maven command line:

mvn clean test -Ddataproviderthreadcount=2 -Dthreadcount=1 -Dparallel="classes" -Dbrowser=firefox

  - dataproviderthreadcount: An integer giving the size of the thread pool to use for parallel data providers
  - threadcount: An integer giving the size of the thread pool to use if you set parallel
=> dataproviderthreadcount*threadcount = number of threads
  - paralle: run parallel processing, with argument: methods |tests | classes
  - browser: set the testing brower, with argument: chrome| firefox. will set default as chrome if donn’t put it in command line
