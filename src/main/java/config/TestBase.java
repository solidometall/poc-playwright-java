package config;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;

import java.nio.file.Paths;

import static utils.BrowserUtils.*;

public class TestBase {

	protected static final String tracePath = "target/surefire-reports/trace/trace.zip";
	protected static final String videoPath = "target/surefire-reports/video/";
	protected static Playwright playwright;
	protected static BrowserType browserType;
	protected static Browser browser;
	protected static BrowserContext context;
	protected BasePage basePage;

	@BeforeClass(alwaysRun = true)
	public void setUpMethod() {
		playwright = Playwright.create();
		browserType = BrowserUtils.getBrowserTypeFromEnv(playwright);
		browser = browserType.launch(setLaunchOptions());
	}

	@BeforeMethod(alwaysRun = true)
	public void setBasePage() {
		context = browser.newContext(setContextOptions());
		// start tracing before creating / navigating a page.
		setContextTracing(context);
		basePage = new BasePage(context.newPage());
	}

	@AfterMethod(alwaysRun = true)
	public void teardownBasePage() {
		teardownContextTracing(context);
		context.close();
		basePage = null;
	}

	@AfterClass(alwaysRun = true)
	public void tearDownMethod() {
		browser.close();
		playwright.close();
	}

	private BrowserType.LaunchOptions setLaunchOptions() {
		// configure browser launch options
		boolean executionMode = isExecutionModeHeadless();
		return new BrowserType.LaunchOptions().setHeadless(executionMode);
	}

	private Browser.NewContextOptions setContextOptions() {
		// configure browser context options
		var contextOptions = new Browser.NewContextOptions();

		if (isVideoRecordingEnabled()) {
			contextOptions
				.setRecordVideoDir(Paths.get(videoPath))
				.setRecordVideoSize(1920, 1280);
		}

		return contextOptions;
	}

	private void setContextTracing(BrowserContext context) {
		if (isTraceRecordingEnabled()) {
			// configure tracing options and start recording
			context.tracing().start(new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));
		}
	}

	private void teardownContextTracing(BrowserContext context) {
		if (isTraceRecordingEnabled()) {
			// stop tracing and export it into a zip archive
			context.tracing().stop(new Tracing.StopOptions()
				.setPath(Paths.get(tracePath)));
		}
	}
}
