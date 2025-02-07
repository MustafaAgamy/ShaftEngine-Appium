# ShaftEngine Appium Demo
This repository demonstrates the usage of **ShaftEngine** for automated testing with **TestNG** for Appium Project setup. The tests utilize the **Page Object Model (POM)** design pattern, and the test execution is parallelized using **ThreadLocal** to ensure thread safety across test methods.

## Project Structure

- **`src/main/java`**:
  - **Page Object Classes**: Contains classes representing the UI elements on the pages and methods to interact with them.
- **`src/test`**:
  - **AppiumSampleTests**: `TestClass` containing the Demo
- **`src/test/resources/testDataFiles`**:
  - **Test Data JSON**: A sample `TestData.json` Data File that you can add the Test Data to it and call them in your Tests
  - **ApiDemos-debug.apk**: A sample `apk` to serve as AUT (Application Under Test)
    
## Setup and Dependencies

The repository uses **ShaftEngine** for browser automation

### Install Dependencies

Ensure you have the necessary dependencies in your `pom.xml` (for Maven)

For more Information visit the following:
  
- [SHAFT_ENGINE](https://github.com/ShaftHQ/SHAFT_ENGINE)
- [SHAFT_ENGINE_PROPERTIES](https://shafthq.github.io/docs/Properties/PropertiesList)
