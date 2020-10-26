# Testing task

## Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#developer)
* [Author](#author)

### <a name="purpose"></a>Project purpose

Program verifies if wall of some configuration 
can be constructed from some set of bricks.

The format for input data is as follows: <br>
1: width and height of wall's shape matrix - two positive integers W and H separated by space on their own line. <br>
2: wall's shape matrix - H strings each of length W, formed just of '1' and '0' symbols with every string on its own line. <br>
3: the count of bricks' sorts - the positive integer C. <br>
4: list of bricks - C lines each containing three positive integers separated by space - width of brick, height of brick and count of such bricks in the set. <br>

Example of source data: <br>
6 3<br>
101101<br>
111111<br>
111111<br>
4<br>
1 1 4<br>
2 1 6<br>
1 3 1<br>
3 4 5<br>
<hr>

### <a name="structure"></a>Project structure

- java 11
- maven 3.6.3
- maven-checkstyle-plugin 3.1.1
- lombok 1.18.12
- junit 4.13

<hr>

### <a name='developer'></a>For developer

To run this project you need to install:

- <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">Java 11</a> or above
- <a href="http://maven.apache.org/download.cgi"> Maven 3.6.3</a>

Add this project to your IDE as Maven project.

Add Java SDK in project structure.

Run the project (<b>Main</b> class). <br>

Unit tests are located in folder <b>src/test/java/com/ksv/service/impl</b>

You can run tests in the terminal with the "<b>mvn test</b>" command.
<hr>

### <a name='author'></a>Author
[Serhii Kinashchuk](https://github.com/serg-ksv)
