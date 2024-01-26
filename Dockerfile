FROM mcr.microsoft.com/playwright/java:v1.41.0-focal

# set the working directory for the application
WORKDIR /usr/src/app

# copy needed files to the app folder
COPY ./pom.xml ./pom.xml
COPY ./poc.playwright.iml ./poc.playwright.iml
COPY ./src/ ./src/
COPY ./.env ./.env

# execute tests
CMD ["mvn", "test"]
