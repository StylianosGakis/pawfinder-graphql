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

## Run on Google Cloud Run (with the command line):

1. [Install & setup gcloud](https://cloud.google.com/sdk/install)

2. Enable the Container, Container Registry, Cloud Build, and Cloud Run APIs:
    ```
    gcloud services enable container.googleapis.com
    gcloud services enable containerregistry.googleapis.com
    gcloud services enable cloudbuild.googleapis.com
    gcloud services enable run.googleapis.com
    ```

3. Export the project's ID in your local .zshrc
   ```
   export PROJECT_ID=YOUR_GCP_PROJECT_ID 
   ```
4. Select your gcp project
   ```
   gcloud config set project $PROJECT_ID
   ```
5. Build the container image on Cloud Build using Buildpacks, storing the image on Google Container Registry:
    ```
    gcloud builds submit --pack=image=gcr.io/$PROJECT_ID/pawfinder-graphql
    ```

6. Deploy on Google Cloud Run:d
   ```
   gcloud run deploy pawfinder-graphql \
     --image=gcr.io/$PROJECT_ID/pawfinder-graphql \
     --project=$PROJECT_ID \
     --platform=managed \
     --allow-unauthenticated \
     --region=europe-north1 \
     --max-instances=4 \
     --no-use-http2 \
     --cpu-throttling
   ```

Project inspired by [PeopleInSpace GraphQL Server](https://github.com/joreilly/PeopleInSpaceGraphQLServer)
