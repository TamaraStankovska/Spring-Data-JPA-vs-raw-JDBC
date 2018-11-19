# Spring Data JPA vs raw JDBC



# 1. Description

This project is made using Java as back-end technology and the Spring Boot framework. For the purpose of this project, which is comparison of performance metrics using Spring Data JPA and raw JDBC,  we made three implementations of queries for a table &quot;Product&quot;. In addition, the queries are written using:

- Spring Data JPA;
- JDBC Template and
- raw JDBC.

We measured **the time of execution** for all of the queries, that is the key metrics used for our evaluation.

# 1.1. Product

The table Product consists of the following properties:

- id;
- retailer\_country,
- rder\_method\_type,
- retailer\_type,
- product\_line,
- product\_type,
- product\_name,
- product\_year,
- quarter\_year,
-

The table &quot;Product&quot; has 50 000 records, used for the evaluation.

# 2. Spring Data JPA

In our project, the queries and methods provided by the Java Persistence API is done by the following steps:

- Create a repository interface and extend one of the repository interfaces provided by Spring Data.
- Add custom query methods to the created repository interface (if we need them that is).
- Inject the repository interface to another component and use the implementation that is provided automatically by Spring.

# 3. JDBC Template

The Spring framework provides a JDBC Template approach for JDBC database access. We can perform all the database operations by the help of a JDBC Template class such as insertion, updation, deletion and retrieval the data from the database.

# 4. Raw JDBC

The for processing any SQL statement with JDBC are:

1. 1)Establishing a connection;
2. 2)Create a statement;
3. 3)Execute the query;
4. 4)Process the _Result Set_ Object;
5. 5)Close the connection.

With raw JDBC are written queries for insertion of data, listing all of the products, finding a product by id or a name, deleting product by id or by name and updating products.

# 5. Metrics and Conclusion
According to this table of metrics, we can see that JDBC Template executes all of the queries in the shortest period of time. Then follows raw JDBC and Hibernate with the biggest execution time.
![](https://github.com/TamaraStankovska/Spring-Data-JPA-vs-raw-JDBC/blob/master/Capture.PNG)
