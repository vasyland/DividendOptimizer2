# Dividend Optimizer on SpringBoot platform
# DividendOptimizer2
Back-end service for the iWS web site

# TODO
```
1. Add different attributes: Invested amount, Available Cash
2. Design decision page
3. Build Decision Service for Decision page
4. Things about Admin override events (holidays, Fed and Bank of Canada Meetings)
```

##Project setup
```
Gradle version: 8.1.1
Java Version: jdk-17.0.2
```

##Build
```
Command line: gradle clean bootJar
```

##App start
```
C:\Tools\jdk-17.0.2\bin\java.exe -jar C:\AV\WorkProjects\DividendOptimizer2\Optimizer\build\libs\divoptimizer-1.0.0.jar
```

##User Points
```
http://localhost:8587/api/user/all
http://localhost:8587/api/user/add
```

##Scenarios Points
```
http://localhost:8587/api/scenario/all
http://localhost:8587/api/scenario/2
http://localhost:8587/api/scenario/add
http://localhost:8587/api/scenario/update
http://localhost:8587/api/scenario/delete/2  - TODO: needs response
```

##Usefull Links
```
https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#publishing-your-application

Default Time stamps
https://thorben-janssen.com/persist-creation-update-timestamps-hibernate/
https://stackoverflow.com/questions/811845/setting-a-jpa-timestamp-column-to-be-generated-by-the-database
https://stackoverflow.com/questions/5571323/mysql-on-update-current-timestamp-not-updating
https://hackmd.io/@8q7xEB2oT4yhx1uwmt34bg/H1Kkaz0ft
```

