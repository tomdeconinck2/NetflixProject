t# NetflixProject

In order to be able to run, ensure the following:

Install:
1. Java (JDK 11), test with java --version 
2. Maven (3.6<), test with mvn -v
3. Git
4. npm (6.10<), test with npm -v
5. Angular client (10.1<), test with ng --version
6. git LFS

To Run:
1. Clone this repo to a local folder (git)
2. Go with your terminal to the new folder
3. Start the microservices with "./main.sh"




Possible Problems?
1. If some errors occur that seem angular related. Try "npm install" and "npm start" at root folder.

2. main.sh not working on windows? Contact Tom or Roy

3. If traingService microservice throws a nullpointerException. Try "git lfs pull" at root folder and try to start the microservice again.


# Current Microservices:

Edge:
1. Eureka: used for service registery and discovery
2. Zuul: the entrypoint of our backend registery. It forwards requests towards the appropiate microservices on the backend. Security aspects will be added here later.
3. Config Server: used to support different configurations (not doing much atm)

User:
1. UserService: used to add/delete users
2. RatingService: used to add/rating rating.
3. FeedbackService: used to add/delete feedback
4. SubscriptionService: used to add/delete subscriptions from users. Will alert users when their subscription is about to end. 


Movie:
1. MovieStreamService: Used to store and stream the mp4 files of the movies.
2. MovieInformationService: Used to scrape, store the metadata of movies and handling the corresponding frontend requests
3. ScrapeFallbackService: Will be used to have a back-up scraping. Hystrix/retry might be used for this. (not doing much atm)

Data:
1. RecommendationService: [Coming soon], this service will calculate personal recommendations based on a testset
2. StatisticsService [Coming soon]







