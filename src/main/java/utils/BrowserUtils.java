package utils;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import io.github.cdimascio.dotenv.Dotenv;
import org.jetbrains.annotations.NotNull;

public class BrowserUtils {
	private static final Dotenv dotenv = Dotenv.configure().load();
	public static BrowserType getBrowserTypeFromEnv(Playwright playwright) {
		String browserType = dotenv.get("BROWSER.TYPE");

		// use chromium as default browser
		if (browserType == null) {
			return playwright.chromium();
		}

		return switch (browserType.toLowerCase()) {
			case "chromium" -> playwright.chromium();
			case "firefox" -> playwright.firefox();
			case "webkit" -> playwright.webkit();
			default -> throw new IllegalArgumentException("The specified browser is not supported: " + browserType);
		};
	}

	public static boolean isExecutionModeHeadless() {
		String executionMode = dotenv.get("EXECUTION.MODE");
		// default execution mode headless
		return !(executionMode != null && executionMode.equalsIgnoreCase("headed"));
	}

	public static boolean isVideoRecordingEnabled() {
		String recordVideo = dotenv.get("VIDEO.RECORDING");
		return recordVideo != null && recordVideo.equalsIgnoreCase("true");
	}

	public static boolean isTraceRecordingEnabled() {
		String showTrace = dotenv.get("TRACE.RECORDING");
		return showTrace != null && showTrace.equalsIgnoreCase("true");
	}

	@NotNull
	public static String getBaseURL() {
		return dotenv.get("BASE_URL", "");
	}
}
