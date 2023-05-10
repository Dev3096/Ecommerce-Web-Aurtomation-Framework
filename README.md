Maven Structured Framework for Ecommerce Application

This project is a Maven structured framework with all necessary automation dependencies to automate the end-to-end flow of an ecommerce application. 
The framework uses the Page Object Model mechanism to drive the locators from respective classes, and it encapsulates object creation within the Page Object classes, thus making it 
easier to manage and maintain tests.

Features

Maven structured framework with all necessary automation dependencies

Implements Page Object Model mechanism

Encapsulates object creation within Page Object classes

Has a Base Test which sets browser configuration details and Global properties

TestNG runner file to trigger the tests with one Single point of execution control

Implements Grouping in TestNG.ml to categorize tests with different tags of execution

Implements Data driven testing & Parameterization using TestNG Data provider HashMap

Implements TestNG Listeners to capture Screenshot on automatic test failures and logging

Implements Extent Report wrapper to generate excellent HTML reports for the application

Necessary changes made to support parallel execution with Thread safe mechanism

Implements TestNG retry mechanism to rerun the failed flaky tests in the application

Framework tests can be run with Maven commands with TestNG Maven integration plugin

Implements Maven Run time variables to replace global parameters of test data at run time

Integrates the Framework with Jenkins with Parameterized Build Pipeline Jobs & Schedule the jobs on specific time frames
