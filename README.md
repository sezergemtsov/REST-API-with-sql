## Hibernate api with Liquibase

This project uses JPQL to handle with SQL data.

SQL in this project represents by PostgreSQL, so to start it, be sure Postgre is installed on your host.

Project would start on port 8081 by default so if it is necessary please change application.properties settings.

Controller has only one GET mapping for request, example of request: "http://localhost:8081/products/fetch-product?name=alexey"

Tables created and filled with Liquibase migrations.