# Getting Started
# Spring Boot Microservice - Movie Catalog app
### This project developed using the following Spring boot, Microservice, Spring Cloud, Spring JPA, H2 Database. 
* **Spring Cloud Netflix Eureka Client** is used to register the movie-catalog-service to the discovery server
* By using the **discovery server**, we can avoid hardcoding the value of localhost and port no in the code. By using **RestTemplate**, each microservice app endpoint is executed
* **Spring Cloud Netflix Hystrix** is used to view the rest endpoint call monitor in hystrix dashboard
* **Spring boot actuator** used to manage and monitor the Spring Boot application for Http endpoints
* **Spring cloud starter config** used to config the microservice specific app properties or yml file in git hub
* Used the **H2 database** for the following tables movie info and movie rating. Just for illustration purpose

# Step 1 - Download cloud config service, discovery server, and all microservice projects

1) Clone the **Spring cloud config service** project to your IDE  
Git Clone: [https://github.com/rajs24/sbt-cloud-config-service.git](https://github.com/rajs24/sbt-cloud-config-service.git)  

2) Clone the **discovery server** project  
Git Clone: [https://github.com/rajs24/sbt-discovery-server.git](https://github.com/rajs24/sbt-discovery-server.git)  

3) Clone the **movie catalog service** project  
Git Clone: [https://github.com/rajs24/sbt-ms-movie-catalog.git](https://github.com/rajs24/sbt-ms-movie-catalog.git)  

4) Clone the **movie info service** project  
Git Clone: [https://github.com/rajs24/sbt-ms-movie-info.git](https://github.com/rajs24/sbt-ms-movie-info.git)  

5) Clone the **movie rating service** project  
Git Clone: [https://github.com/rajs24/sbt-ms-movie-rating.git](https://github.com/rajs24/sbt-ms-movie-rating.git)  

# Step 2 - Follow the sequence to run the `cloud config service`, `discovery server`, and `all microservice apps`

1) Start the **Spring cloud config service** project

2) Start the **discovery server** project

3) Start the **movie catalog service** project

4) Start the **movie info service** project

5) Start the **movie rating service** project


# Step 3 - Endpoint Details
GET  
H2 db as pre-defined insert datasets for movie info and movie rating  
`/catalog/{userid}` 

Sample:  
`catalog/1`  
`catalog/2`  
`catalog/3`  
`catalog/4` 
```
http://localhost:8081/catalog/1
```
GET  
get all movie details from db   
```
http://localhost:8081/catalog/all
```
H2 Console
```
http://localhost:8081/h2
```
Microservice specific yml and properties files in the git repository
```
http://localhost:8085/movie-catalog-service/default
http://localhost:8085/movie-rating-service/default
http://localhost:8085/movie-info-service/default
http://localhost:8085/discovery-server/default
```
Eureka Dashboard  
`Microservices registered service details`
```
http://localhost:8761/
```
Hystrix Dashboard
```
http://localhost:8081/hystrix
```
