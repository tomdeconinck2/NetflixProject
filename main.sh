#!/bin/sh
echo "Running the application..."
x = 1
kill $(lsof -t -i:8761)
kill $(lsof -t -i:8080)
kill $(lsof -t -i:8889)
kill $(lsof -t -i:8888)
kill $(lsof -t -i:4200)
cd edge
cd eureka-server/
mvn clean package
java -jar ./target/eureka-server-0.0.1-SNAPSHOT.jar &
cd ..
echo "Eureka started up"
sleep x
cd zuul-proxy
mvn clean package
java -jar ./target/zuul-proxy-0.0.1-SNAPSHOT.jar &
cd ..
echo "Zuul started up"
sleep x 
cd config-server
mvn clean package
java -jar ./target/config-server-0.0.1-SNAPSHOT.jar &
cd ..
echo "Config server started up"
sleep x
cd ..
cd test
mvn clean package
java -jar ./target/test-0.0.1-SNAPSHOT.jar &
cd ..
sleep x
echo "backend started"
cd Frontend
ls
cd Netflix
npm start
sleep x
echo "frontend started"
