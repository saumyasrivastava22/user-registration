# User Registration microservice-primer
Microservice for user registration
* Overview
* High level design (HLD)
* Low level design (LLD)

## Architecture

### Overview

## Study Material
What this microservice template covers:
 * REST Endpoints
 * Reactive web stack
 * Integration with a mysql server, deployed on a separate docker container
 * Generate a docker image, readme to deploy this in a docker container

## Deployment 
### Setting up MySQL server & client in a docker containers
* Creating a network
    > docker network create users-mysql-client-network

* Starting a MySQL server instance 
    > docker run -p 3307:3306 --name users-mysql-server -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=users -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d mysql:latest

    ... where user-mgmt-mysql is the name you want to assign to your container, password is the password to be set for the MySQL root user and tag is the tag specifying the MySQL version you want. [See the list above for relevant tags](https://hub.docker.com/_/mysql).

### Setting up user-registration microservice in a docker container ([Reference](https://www.youtube.com/watch?v=fvEWoy1xOvo))

  * Build docker image using Dockerfile in root location of project 
    > docker build . -t user-registration-0.0.1-snapshot
  * Run the docker image in a new container, expose server port using '9876:9876', link it to mysql-server container using image 'user-registration-0.0.1-snapshot'                                                                       
    > docker run -p 9876:9876 --name user-registration --link users-mysql-server:mysql -d user-registration-0.0.1-snapshot
  * Loading setup.sql & test-data.sql 
    > docker exec -it users-mysql-server /bin/bash
    bash# mysql -uroot -p -A
    Enter password: xxxx
    mysql> select ...

## Useful commands
  * Docker commands
     * Start docker container
        > docker start user-registration
     * Stop docker container
        > docker stop user-registration
     * Restart docker container
        > docker restart user-registration
     * View logs
        > docker logs user-registration
