# This automation project implements E2E testing using Playwright, Java and maven.
The demo site used is [atsea-sample-shop-app] (https://github.com/dockersamples/atsea-sample-shop-app/).

# Configuration

## Execute tests from Docker
Docker and docker-compose installed are needed.

"docker-compose" file configures database and application server, and executes tests.

Build and run the containers:

`docker-compose up --build --force-recreate`

## From local env
If you want to run tests from your local environment against the sample site,
first of all you will need to install project dependencies using maven:

`mvn clean install`

Next, you will need to run the docker compose file to create a simplified development environment consisting only of the application server and database.

`docker-compose -f docker-compose-sample_site_only.yml up -d`


### Headed browser

`mvn test -Dexecution.mode="headed"`

### Debug mode

`PWDEBUG=1 mvn test`

or

`PWDEBUG=console mvn test`

When running in Debug Mode with `PWDEBUG=console`, a playwright object is available in the Developer tools console.
Developer tools can help you to:

* Inspect the DOM tree and find element selectors
* See console logs during execution (or learn how to read logs via API)
* Check network activity and other developer tools features

### Verbose API logs

Playwright supports verbose logging with the DEBUG environment variable.

`DEBUG=pw:api mvn test`

### Record execution video

`mvn test -Dvideo.record="true"`

### Record failed execution trace

`mvn test -Dtrace.record="true"`
