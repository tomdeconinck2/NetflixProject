#!/bin/sh
echo "Running the application..."
for port in 8761 8080 8889 8888 8887 8886 8885 8901 8904 8905 4200
do
kill $(lsof -t -i:$port)
done


echo "EDGE Startups:"
cd edge/eureka-server
mvn clean package
java -jar ./target/eureka-server-0.0.1-SNAPSHOT.jar &
cd ../..

cd edge/SecurityServer/
mvn clean package
java -jar ./target/SecurityServer-0.0.1-SNAPSHOT.jar &
cd ../..

cd edge/config-server
mvn clean package
java -jar ./target/config-server-0.0.1-SNAPSHOT.jar &
cd ../..

cd test
mvn clean package
java -jar ./target/test-0.0.1-SNAPSHOT.jar &
cd ..
sleep x

echo "MOVIE PACKAGE STARTUPS: "
cd movie/movie-data-collector
mvn clean package
java -jar ./target/movie-data-collector-0.0.1-SNAPSHOT.jar &
cd ../..

cd movie/TrainingService
mvn clean package
java -jar ./target/TrainingService-0.0.1-SNAPSHOT.jar &
cd ../..

cd movie/StreamService
mvn clean package
java -jar ./target/StreamService-0.0.1-SNAPSHOT.jar &
cd ../..


echo "USER PACKAGE STARTUPS: "
cd user/feedbackService
mvn clean package
java -jar ./target/feedbackService-0.0.1-SNAPSHOT.jar &
cd ../..

cd user/ratingService
mvn clean package
java -jar ./target/ratingService-0.0.1-SNAPSHOT.jar &
cd ../..

cd user/UserService
mvn clean package
java -jar ./target/UserService-0.0.1-SNAPSHOT.jar &
cd ../..

echo "Finished"


cd Frontend/Netflix
npm start
sleep x
echo "frontend started"
cd ../..









