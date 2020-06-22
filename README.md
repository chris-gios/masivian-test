# Masivian-Test

This project contains the masivian clean code test

# Masivian Clean Code - Artifact

## Development server

Run this inside project folder `gradlew bootrun` for a dev environment. Server runs on `http://localhost:8080/`.

## Build Artifact

Run this inside project folder `gradlew bootjar` to build the project. 

## Run Compiled Artifact

Run this inside project folder `java -jar build/libs/clean-code-test-0.0.1-SNAPSHOT.jar` to run the project. 

## Stop

press `Ctrl + c` to stop the project. 

# Docker
This step requires to complete the (**Build Artifact**) step from (**Masivian Clean Code - Artifact**) section

## Build Image

Run this inside project folder `docker build .`

# Docker Compose
This step requires to complete the (**Build Image**) step in (**Docker**) section

## Build Compose

Run this inside project folder `docker-compose build`

## Run Compose

Run this inside project folder `docker-compose up`

## Stop Compose

press `Ctrl + c` to stop the project and run this inside project folder `docker-compose down`

# API Definitions
- Link : [Create Roulette](api-docs/roulette-create.md)
- Link : [Find All Roulettes](api-docs/roulette-list.md)
- Link : [Open Roulette](api-docs/roulette-open.md)
- Link : [Close Roulette](api-docs/roulette-close.md)
- Link : [Make a Roulette Bet](api-docs/roulette-make-bet.md)