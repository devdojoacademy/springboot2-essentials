## About
This repo represents what we explained in the training available in this [playlist](https://www.youtube.com/playlist?list=PL0Un1HNdB4jHTXBeJ8u3Kaz0NMxuMkmOY) on YouTube.

Each video in that playlist is in a different branch, named ‘video<#number>’. Checkout the latest video branch to get the ‘last state’ of the project.

The content of this repo is for training, don’t blindly copy and paste in a code that will go to production

## Requirements

1. Java 11
2. Docker or MySQL running natively

## Running

1. Clone this repo
2. Git checkout <latest video branch>
3. In the terminal run `docker-compose up` if you don’t have a database running on 3306. If you do, configure the application.yml file to connect to the running database
4. Start the application by running in the terminal `mvn spring-boot:run`
5. Execute the script `init.sql` inside `resources` to generate some users
6. The password for both users is `academy`
