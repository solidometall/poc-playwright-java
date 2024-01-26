# This automation project implements E2E tests using Playwright, Java and maven.
- The demo site used is [atsea-sample-shop-app](https://github.com/dockersamples/atsea-sample-shop-app/).
- Docker and docker-compose are needed.

# Configuration

## Execute tests from Docker

"docker-compose" file configures database and application server, and executes tests.

Build and run the containers:

`docker-compose up --build --force-recreate`

## From local environment
If you want to run tests from your local environment against the sample site,
first of all you will need to install project dependencies using maven:

`mvn clean install`

Next, you will need to run the docker compose file to create a simplified development environment consisting only of the application server and database.

`docker-compose -f docker-compose-sample-site-only.yml up --build --force-recreate`

### Browsers

Supported browsers are: chromium (default), firefox & webkit.

You can configure the variable `BROWSER.TYPE` in `.env` file.

### Headed browser

You can configure the variable `EXECUTION.MODE=headed` in `.env` file

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

You can configure the variable `VIDEO.RECORDING=true` in `.env` file

### Record failed execution trace

You can configure the variable `TRACE.RECORDING=true` in `.env` file
