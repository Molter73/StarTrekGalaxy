# StarTrekGalaxy
In a far away galaxy, three civilizations coexist. Vulcanos, Ferengis y Betasoides. Each of them live in peace in their own planet.

They predict weather conditions through a complex software system.

This project is a replication of said system.

## Getting Started

This project is built with maven, so simply cloning the repository and running mvn install on the root pom.xml should get everything built

### Prerequisites

For the rest-api and database modules an application.properties is required in order for them to access a physical DB. A template for this files is provided below.

### database application.properties

spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://<DB_URL>/<DB_NAME>
spring.datasource.username=<USER_NAME>
spring.datasource.password=<PASSWORD>

spring.jpa.hibernate.ddl-auto=create

-- Replace the values enclosed in <> with the corresponding information for your system

### rest-api application.properties

spring.datasource.username=<USER_NAME>
spring.datasource.password=<PASSWORD>
spring.datasource.continue-on-error=true
spring.datasource.initialization-mode=always

spring.cloud.gcp.sql.database-<DB_NAME>
spring.cloud.gcp.sql.instance-connection-name=<CLOUD_SQL_DB_INSTANCE_CONECTION_NAME>

-- Replace the values enclosed in <> with the corresponding information for your system

This version of the application.properties is used with spring cloud SQL only, although some minor tweaks to this and the pom.xml would get the project running on a local DB too. Refer to the database in this project for an example

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Mauro Moltrasio** - *Initial work* - [Molter73](https://github.com/Molter73)
