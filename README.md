# PawFinder GraphQL Server

GraphQL wrapper around [PetFinder API](https://www.petfinder.com/developers/v2/docs/) with limited functionality built
for fun.

## Setup:

Rename [application-template.yml](./src/main/resources/application-template.yml) file to `application.yml` and replace
the client secret and ID with your own generated from the
[PetFinder developers page](https://www.petfinder.com/developers/).

## Run Locally:

1. Start the local server: `./gradlew bootRun`
1. Open: [localhost:8080/playground](http://localhost:8080/playground)

## Local Docker Build & Run

1. [Install Docker](https://docs.docker.com/get-docker/)

2. Build the image
    ```
    ./gradlew bootBuildImage
    ```
   The image name is setup in the [gradle file](build.gradle.kts)


4. Run image:
    ```
    docker run -p8080:8080 pawfinder-graphql
    ```

5. Open: [localhost:8080/playground](http://localhost:8080/playground)

Project inspired by [PeopleInSpace GraphQL Server](https://github.com/joreilly/PeopleInSpaceGraphQLServer)
