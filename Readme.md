# Headed browser

`mvn test -Dexecution.mode="headed"`

# Debug mode

`PWDEBUG=1 mvn test`

or

`PWDEBUG=console mvn test`

When running in Debug Mode with `PWDEBUG=console`, a playwright object is available in the Developer tools console.
Developer tools can help you to:

* Inspect the DOM tree and find element selectors
* See console logs during execution (or learn how to read logs via API)
* Check network activity and other developer tools features

# Verbose API logs

Playwright supports verbose logging with the DEBUG environment variable.

`DEBUG=pw:api mvn test`

# Record execution video

`mvn test -Dvideo.record="true"`

# Record failed execution trace

`mvn test -Dtrace.record="true"`
