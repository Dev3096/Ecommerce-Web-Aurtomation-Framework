**Maven Structured Framework for Ecommerce Application**

This project is a Maven structured framework with all necessary automation dependencies to automate the end-to-end flow of an ecommerce application. 
The framework uses the Page Object Model mechanism to drive the locators from respective classes, and it encapsulates object creation within the Page Object classes, thus making it 
easier to manage and maintain tests.

**Features**

1. Maven structured framework with all necessary automation dependencies

2. Implements Page Object Model mechanism

3. Encapsulates object creation within Page Object classes

4. Has a Base Test which sets browser configuration details and Global properties

5. TestNG runner file to trigger the tests with one Single point of execution control

6. Implements Grouping in TestNG.ml to categorize tests with different tags of execution

7. Implements Data driven testing & Parameterization using TestNG Data provider HashMap

8. Implements TestNG Listeners to capture Screenshot on automatic test failures and logging

9. Implements Extent Report wrapper to generate excellent HTML reports for the application

10. Necessary changes made to support parallel execution with Thread safe mechanism

11. Implements TestNG retry mechanism to rerun the failed flaky tests in the application

12. Framework tests can be run with Maven commands with TestNG Maven integration plugin

13. Implements Maven Run time variables to replace global parameters of test data at run time

14. Integrates the Framework with Jenkins with Parameterized Build Pipeline Jobs & Schedule the jobs on specific time frames
