# Simple Spring Boot Authentication with OAuth2 and JWT (REST)

This is a sample project about authentication using OAuth2 and JWT on Spring Boot


Technology stack:

* Spring Boot
* Spring Security
* Spring Data JPA
* OAuth2
* H2 Database
* Lombok

## How to Run 

This application is packaged as a jar which has Tomcat embedded. No java application server installation is necessary. You can run it using the ```mvn spring-boot:run``` command.

* Clone this repository 
```
git clone https://github.com/bedirhanatasoy/spring-boot-authentication-jwt
```
* Make sure you are using JDK 1.8 and Maven 4.0.0
* Go into project folder
* You can build the project, run the tests and run the application by running this:
```
     mvn spring-boot:run 
```

Once the application runs you should see something like this

```
2017-11-26 11:11:25.111  INFO 31505 --- [main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-11-26 11:11:25.118  INFO 31505 --- [main] c.b.springboot.auth.Application          : Started Application in 10.037 seconds (JVM running for 13.963)
```

## About the Project

The project is just an authentication system which uses REST service with JSON Web Tokens. It uses an embedded H2 database to store the data. You can also implement another database such as MySQL. 

You can use this sample project to understand JSON Web Tokens, OAuth2 and some configs of Spring Security.

The application uses 8080 port. You can change the port by adding ```server.port = XXXXX``` to ```application.properties``` in ```src/main/resources```


# REST-API Docs #
