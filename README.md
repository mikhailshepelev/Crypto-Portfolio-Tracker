# Cryptocurrency portfolio tracking service  

## About  
This application contains only back-end. It allows the user to add, remove and list various cryptocurrencies and tracks their current market value. When user sends request to back-end with intention to trade money for any cryptocurrency, application independently gets information about current market price for targeted cryptocurrency from [Bitfinex API](https://docs.bitfinex.com/docs) and saves this request to database. All saved requests can be deleted, quieried or updated via corresponding endpoints.

## Installation and usage  
Before running an application, make sure that you downloaded and installed:  
1.  [Java SE Development Kit 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)   
2.  [Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download)  

## To setup and run application  
1. Open Intellij IDEA and clone this project by clicking "Get from Version Control" in the starting window  
2. Wait until maven will resolve all required dependencies  
3. Install ["Lombok"](https://www.jetbrains.com/help/idea/managing-plugins.html) plugin in Intellij IDEA  
4. Open file named "src/main/java/com/msh/cryptoportfoliotracking/CryptoportfoliotrackingApplication.java" in IntelliJ and click on green arrow near "main" method to run application  

## Endpoints for testing  
Add new entry(HTTP method - POST): http://localhost:8080/api/cryptoentries  
Get all entries(HTTP method - GET): http://localhost:8080/api/cryptoentries  
Get specific entry(HTTP method - GET, {id} - id of specific entry): http://localhost:8080/api/cryptoentries/{id}  
Delete specific entry(HTTP method - DELETE, {id} - id of specific entry): http://localhost:8080/api/cryptoentries/{id}  
Update specific entry(HTTP method - PUT): http://localhost:8080/api/cryptoentries  
Get combined current market value(HTTP method - GET): http://localhost:8080/api/cryptoentries/totalamount  

## Author  
[Mikhail Shepelev](https://github.com/mikhailshepelev)  
