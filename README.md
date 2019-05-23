# TestVagrant hiring challenge for applicants 

About the codebase:
---------------------------------
*This is a simple test project for testing a few scenarios on a sample flight/hotel booking website. There are **3 tests** in total spread over 3 test classes. Following tech stack has been used to develop the same.*

**Tech Stack:** *Java*  *Selenium* *TestNG*  *Gradle/Maven*

**The parameters of evaluation**
----------------------------------
1. Naming Conventions & readability of code
2. Modularization & Abstraction
3. Demonstration of OO concepts & Design Patterns
4. Etiquette of Version control

Problem Statement
----------------------------------
**Tasks:**

1. Test are failing which needs your expertise to fix it.
2. Review and point out design issues with the current codebase/framework, if any.
3. Improve/refactor the code to implement your suggestions.

**Expectation:**
1. Create a GitHub account if not existing already.
2. Fork this repo (DO NOT CLONE).
3. Fix the errors and refactor the code, consider **abstractions, reusability and maintenance.**
4. Make sure you make multiple check-ins in the process, we would love to see your progress bit by bit.
5. Also check-in a separate file where you should list all your code review comments.
6. Send us the link of your GitHub repo to **careers@testvagrant.com**. Also attach your **resume**.

=================================================================================================================
Feedback on Project Structure:
========================================================
1. Not following Complete Maven Architecture, according to Maven architecture all the design patterns should be stored in src/main/java and all the test cases should be stored in src/test/java. 
2. A Proper name should be given to a package. 
3. JRE version should be updated to latest.
4. A Base class to setup the test environment.  
5. A util class should be created to store the comonly used methods. 


Feedback on FlightBookingTest.Java
=========================================================
1. WebElements should be stored in Object Repository or it should be stored in POM Pattern. 
2. Asseration shoud be used to validate the tests. 


Feedback on HotelBookingTest.java
=========================================================
1. WebElements should be stored in Object Repository or it should be stored in POM Pattern. 
2. Asseration shoud be used to validate the tests. 

Feedback on SignInTest.java	
=========================================================
1. WebElements should be stored in Object Repository or it should be stored in POM Pattern. 
2. Asseration shoud be used to validate the tests. 


Feedback on pom.xml
=========================================================
1. It should have the poi dependecies so that we can read the data from excel
2. It should have surefire plugin to setup the goal and run the test via mvn commands

Explanation of New Framework:
=========================================================
1. Base Package consist base class and base class is parent of all the other classes
2. Base class used to setup the configuration for automation testing
3. Pages Package consist all the pages and every page class consist their webelements and actions
4. TestData Package consist of a excel file which is used to store all the test data required for testing
5. util package consist Util and MSExcelAutomation Class
6. Util class is containing the all the comonly used methods
7. MSExcelAutomation class is used to read the data from excel.
