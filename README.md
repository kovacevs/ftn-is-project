# ftn-is-project
### Faculty of technical science - information system (student project)

Java EE project based on:
* JBoss AS 7.1
* MySql 5.5
* JPA
* JAX-WS
* JSF
* WSS4J

---

### Project overview
FTN-IS application depicts simplified faculty information system with three types of users: system admin, teacher and student. It provides protection from unauthorised access to data based on user sessions. Application data is stored in MySQL 5.5 database, application server and web container used is JBoss AS 7.1. Application architecture is defined in *picture 1*.

#### Architecture
*Picture 1* shows three-layered client-server architecture, with MySQL database as data store and JPA Entitys and web services (implemented accordint to JAX-WS specification) as middle tier business logic. Client application uses JSF framework and it communicates with web services over SOAP protocol.
