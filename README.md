## Hibernate api

This project uses JPQL to handle with SQL data.

SQL in this project represents by PostgreSQL, so to start it, be sure Postgre is installed on your host.

Project would start on port 8081 by default so if it is necessary please change application.properties settings.

Controller has one GET mapping for request, example of request: "http://localhost:8081/products/fetch-product?name=alexey"
And also one more GET mapping to fill tables with data, example of request: "http://localhost:8081/fill"