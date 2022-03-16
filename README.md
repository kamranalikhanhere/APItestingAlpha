# QA-Coding-challenge
Hello!!

Here you can find the automation test of the assignment

Project is made basically using:

Java 
Cucumber
Junit
Maven
IntelliJ IDEA

Project Structure

models: This directory contains all the response pojos of each json placeholder endpoint api: This package contains methods testcases: This package contains Test Cases.

Installation

Open the project in IntelliJ. Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

$ mvn clean install

If the build is successful. All the required dependencies are installed successfully. But if the build fails, make sure to to resolve all the issues in order to execute tests successfully. Make sure that config.properties path in Property Reader class is set according to your Operating System Environment.

Execute Tests

Run the following command in Terminal to execute tests.

$ mvn clean verify

