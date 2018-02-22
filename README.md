

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```



Project instructions:

1. Create new Maven project.
2. Add Dependencies:
	2.1 maven-resources-plugin;
	2.2 testng;
	2.3 selenium chrome driver;
	2.4 selenium java from http://docs.seleniumhq.org/download/maven.jsp
3. Add plugins:
	3.1 maven-compiler-plugin;
	3.2 maven-surefire-plugin.
4. Make sure the ChromeDriver is installed properly (local or maven dependency?).
5. Do a mvn -install in the Project directory to fix any plugin bugs.
6. mvn clean test command.
7. Configure TestNG plugin.
8. Configure TestNG test suite
9. Make sure testng pluggin settings in POM.xml file - dependency properties are set as COMPILE scope instead of TEST.