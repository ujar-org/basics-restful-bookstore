## Book Store REST API

[![Build Status](https://drone.ujar.org/api/badges/ujar-org/basics-restful-bookstore/status.svg?ref=refs/heads/develop)](https://drone.ujar.org/ujar-org/basics-restful-bookstore)

Simple bookstore app for demo purpose using Spring Boot.

### Pre-Requisites to run this example locally

- Setup git command line tool (https://help.github.com/articles/set-up-git)
- Clone source code to the local machine:

```
git clone https://github.com/ujar-org/basics-restful-bookstore.git

cd basics-restful-bookstore
```

- Install Docker [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/) - at least 1.6.0
- Add new version of docker-compose [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)
- Spin-up single instance of Postgresql by running command:

```
docker-compose -f docker-compose.dev.yml up -d
```

### Running locally

This application is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built
using [Maven](https://spring.io/guides/gs/maven/). You can build a jar files and run it from the command line:

- Create jar packages:

```
mvn package
```

- Run **restful-bookstore** app:

```
java -jar target/*.jar
```

## Code conventions

The code follows [Google Code Conventions](https://google.github.io/styleguide/javaguide.html). Code
quality is measured by:

- [Sonarqube](https://sonarqube.ujar.org/dashboard?id=ujar-org%3Abasics-restful-bookstore)
- [PMD](https://pmd.github.io/)
- [CheckStyle](https://checkstyle.sourceforge.io/)
- [SpotBugs](https://spotbugs.github.io/)

### Tests

This project has standard JUnit tests. To run them execute this command:

```
mvn test -P testcontainers-support
```

It is mandatory to keep test code coverage not below **80** percents and cover all business logic and edge cases.
