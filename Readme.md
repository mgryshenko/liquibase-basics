Simplest project to play with basics of Liquibase (https://www.liquibase.com/)

How to run: 
- create executable .WAR file
```
mvn clean install
```
- run .WAR with spring-boot plugin (already defined in pom.xml)
```
mvn spring-boot:run
```

H2 database is used, so no additional clicks needed. Uses external files to persist state between application runs