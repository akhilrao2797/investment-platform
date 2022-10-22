# investment-platform
Investment platform
A web based app that provides a single platform where an investor gets to know the various alerts of investment / trade from investment and asset management companies along with the registered stock market analysts.

**Tech Stack**
* Spring Boot
* Spring Security
* MySQL
* Spring DATA JPA

**Application Engineering**<br>
We have come across multiple SEBI registered Analyst and other brokerage companies that give out the ratings and performance of the company, its stock and the individual promoters of the company, but we don't have a single platform that unites the stock market traders and these analysts.

This platform enables the traders and investors to learn and seek information from the analyst(paid and free serviced) and apply the same during their daily interaction with the stock market.

This application uses a Factory Design pattern to achieve the type of trade that the analyst posts, and the same being persisted into the MySQL database based on the type. Users and analyst need to be authenticated using the JWT token which can be retrieved from the exposed API. Currently, the payment service is not integrated with the application. This feature would be a part in the later coming developments.

**Swagger**<br>
http://localhost:8080/swagger-ui/ <br>
http://localhost:8080/v2/api-docs <br>


TODOs
Create a scheduler to clear data older than 1 month.
Introduce caching of analyst post.
Manage payment service using 3rd party APIs.
