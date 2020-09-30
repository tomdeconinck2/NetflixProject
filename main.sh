#!/bin/sh
echo "Running the application..."
cd edge
cd eureka-server/
mvn clean package
java -jar ./target/eureka-server-0.0.1-SNAPSHOT.jar &
cd ..
sleep 5
echo "Eureka started up"
cd zuul-proxy
mvn clean package
java -jar ./target/zuul-proxy-0.0.1-SNAPSHOT.jar &
cd ..
echo "finished"
