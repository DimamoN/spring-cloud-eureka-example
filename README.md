# spring-cloud-eureka-example
Simple setup with Eureka server and a few clients

> FIY: db service it's a fake

# Scheme:

![picture](https://preview.ibb.co/kdeBso/scheme.png)

# How to open project in Intelij IDEA:

Import project:
1) File -> Open -> eureka-server/pom.xml (open as project)
2) Maven Projects -> Add Maven Projects (+) -> news-service/pom.xml
3) Maven Projects -> Add Maven Projects (+) -> db-service/pom.xml

Run every instance:
* EurekaServerApplication
* NewsServiceApplication
* DbServiceApplication

Test:
* Go on [http://localhost:8761](http://localhost:8761) - and you should see that **DB-SERVICE** and **NEWS-SERVICE** are already registered.
