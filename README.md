# spring-cloud-eureka-example
Simple setup with Eureka server, Zuul, Spring Config Server and a few clients
> Eureka-Server is also a Zuul proxy

> FIY: DB service it's a fake. There no real db connections. Add if you need it.

# Scheme:

![picture](https://image.ibb.co/jAZ0no/12323.png)

# How to open project in Intelij IDEA:

Import project:
1) File -> Open -> eureka-server/pom.xml (open as project)
2) Maven Projects -> Add Maven Projects (+) -> news-service/pom.xml
3) Maven Projects -> Add Maven Projects (+) -> db-service/pom.xml
4) Maven Projects -> Add Maven Projects (+) -> config-server/pom.xml

Configure *Local Git Repo*:
1) Create folder at *${user.home}/spring-cloud-config-repo* 
> Path can be changed with param *spring.cloud.config.server.git.uri* in a *config-server/src/main/resources/application.config*

> Windows: C:/Users/Username     
> Linux: /home/user

2) Copy all files from **configRepo** project folder to *${user.home}/spring-cloud-config-repo*
3) Go to *${user.home}/spring-cloud-config-repo* and exec next commands
```console
git init
git add .
git commit -m "init"
```

Now run every instance in your IDE:
* EurekaServerApplication
* ConfigServerApplication
* NewsServiceApplication
* DbServiceApplication

How to test:
* Go on [http://localhost:8761](http://localhost:8761) - and you should see that **CONFIG-SERVER**, **DB-SERVICE**, **NEWS-SERVICE** are already registered.
* Get request to Zuul: http://localhost:8761/api/db-service/rest/db/123456789
* Get request to News: http://localhost:8761/api/news-service/rest/search/123456789
* Get request for properties: http://localhost:8761/api/db-service/rest/db/property1

