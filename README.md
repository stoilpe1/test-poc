# Test Proof of Concept project

### Framework built on Selenium-Java, TestNG, Maven

## Prerequisites:

1. Java should be installed and configured
2. Maven should be installed and configured
3. Chrome and Firefox browsers should be installed

## Installation:

1. **Copy** repo
2. Go to **src/main/resources** and add **WebDriver** instances from the following locations:
- ChromeDriver (for Chrome browser) at [ChromeDriver archive](https://chromedriver.storage.googleapis.com/index.html)<p>*Latest version is always prefered*
*Latest version tested in project = v2.35 32bit*</p>
- GeckoDriver (for Firefox browser) at [GeckoDriver archive](https://github.com/mozilla/geckodriver/releases)
<p>*Latest version is always prefered*
*Latest version tested in project = v0.19.1 64bit*</p>

## Run tests:

### Tests can be run by executing **pom.xml** of the project:

1. Open terminal and go to project directory where **pom.xml** is located
2. To execute test suite run command **"mvn clean install"**

## Notes:

1. Make sure Java path is configured properly
2. Make sure Maven path is configure properly
3. Make sure browser binaries are configured properly