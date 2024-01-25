package utils;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserUtils {
	public static BrowserType getBrowserTypeFromEnv(Playwright playwright) {
		String browserType = System.getenv("browser.type");

		if (browserType == null) {
			// use chromium as default browser
			return playwright.chromium();
		}

		return switch (browserType.toLowerCase()) {
			case "firefox" -> playwright.firefox();
			case "webkit" -> playwright.webkit();
			default -> throw new IllegalArgumentException("Tipo de navegador no válido: " + browserType);
		};
	}

	// validamos si el browser es headed o headless, por default headless = true
	public static boolean isExecutionModeHeadless() {
		String executionMode = System.getProperty("execution.mode");
		return !(executionMode != null && executionMode.equalsIgnoreCase("headed"));
	}

	public static boolean isVideoRecordingEnabled() {
		String recordVideo = System.getProperty("video.record");
		return recordVideo != null && recordVideo.equalsIgnoreCase("true");
	}

	public static boolean isTraceRecordingEnabled() {
		String showTrace = System.getProperty("trace.record");
		return showTrace != null && showTrace.equalsIgnoreCase("true");
	}
}
