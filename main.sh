#!/bin/sh
echo "Running the application..."
x = 1
kill $(lsof -t -i:8761)
kill $(lsof -t -i:8080)
kill $(lsof -t -i:8889)
kill $(lsof -t -i:8888)
kill $(lsof -t -i:8887)
kill $(lsof -t -i:8886)
kill $(lsof -t -i:8885)
kill $(lsof -t -i:8901)
kill $(lsof -t -i:4200)
cd edge
cd eureka-server/
mvn clean package
java -jar ./target/eureka-server-0.0.1-SNAPSHOT.jar &
cd ..
echo "Eureka started up"
sleep x

cd SecurityServer/
mvn clean package
java -jar ./target/SecurityServer-0.0.1-SNAPSHOT.jar &
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

cd movie/movie-data-collector
mvn clean package
java -jar ./target/movie-data-collector-0.0.1-SNAPSHOT.jar &
cd ../..
sleep x

cd movie/TrainingService
mvn clean package
java -jar ./target/TrainingService-0.0.1-SNAPSHOT.jar &
cd ../..
sleep x



cd user/feedbackService
mvn clean package
java -jar ./target/feedbackService-0.0.1-SNAPSHOT.jar &
cd ../..
sleep x

cd user/ratingService
mvn clean package
java -jar ./target/ratingService-0.0.1-SNAPSHOT.jar &
cd ../..
sleep x

cd user/UserService
mvn clean package
java -jar ./target/UserService-0.0.1-SNAPSHOT.jar &
cd ../..
sleep x

echo "userservice started up"


cd Frontend/Netflix
npm start
sleep x
echo "frontend started"
cd ../..









