This app is build on top of "gettyimages/spark" image, which provides standard Spark environment.

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

$ docker run --rm -it gettyimages/spark bin/spark-submit --class BasicRDDLocal --master spark://<master-host ip>:6066 --deploy-mode cluster /app/deploy/spark-cluster-app-1.1.jar

###### or

$ docker exec -it <master-name> /bin/bash

$ bin/spark-submit --class BasicRDDLocal --master spark://172.16.5.34:6066 --deploy-mode cluster /app/deploy/spark-cluster-app-1.1.jar
