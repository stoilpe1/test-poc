# Test Proof of Concept project

### Framework built on Selenium Java, TestNG, Maven

## Prerequisites:

1. Install Java and configure it
2. Install Maven and configure it

## Installation:

1. **Copy** repo
2. Go to **src/main/resources** and add **WebDriver** instances from the following locations:
2.1 ChromeDriver (for Chrome browser) at [ChromeDriver archive](https://chromedriver.storage.googleapis.com/index.html)
*Latest version is always prefered*
*Latest version used in project = v2.35 32bit*
2.2 GeckoDriver (for Firefox browser) at [GeckoDriver archive](https://github.com/mozilla/geckodriver/releases)
*Latest version is always prefered*
*Latest version used in project = v0.19.1 64bit*

## Run tests:

### Tests can be run by executing pom.xml of the project:

1. Open terminal and go to project directory where pom.xml is located
2. To execute test suite run command "mvn clean install"

## Notes:

1. Make sure Java path is configured properly
2. Make sure Maven path is configure properly
3. Make sure browser binaries are configured properly in order for the webdriver isntances to execute without errors