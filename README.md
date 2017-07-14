This Spark app written on Java and meant to run on cluster - Spark Standalone Cluster at the moment.

Main intention is to start the clusters on Docker containers. For that "gettyimages/spark" image has been used as base, which provides standard Spark environment running on a Linux platform.

The docker-compose.yml has also been adopted from "gettyimages" and plan is to extend it further.

The following steps demonstrate how to build and run the app on Spark Standalone Cluster.

### build the app
$ cd /path/to/docker-spark-app-cluster

$ mvn clean package

### copy the jar in a particular location
$ cp target/spark-cluster-app-1.1.jar src/main/docker/deploy/

### start standalone cluster in the form of docker containers for master and worker
$ cd src/main/docker

$ docker-compose up

### submit application on standalone cluster

$ docker run --rm -it gettyimages/spark bin/spark-submit --class BasicRDDLocal --master spark://172.16.5.26:6066 --deploy-mode cluster /app/deploy/spark-cluster-app-1.1.jar

###### or

$ docker exec -it  docker_master_1 /bin/bash

$ bin/spark-submit --class BasicRDDLocal --master spark://172.16.5.26:6066 --deploy-mode cluster /app/deploy/spark-cluster-app-1.1.jar

### check your app's webui
http://localhost:8080
