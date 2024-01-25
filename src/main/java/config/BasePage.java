package config;

import com.microsoft.playwright.Page;
import pom.pages.LandingPage;

public class BasePage {

	// protected static final String BASE_URL = "http://localhost:8080/index.html";
	protected static final String BASE_URL = "http://atsea:8080";
	protected Page page;

	public BasePage(Page page) {
		this.page = page;
	}

	public BasePage getBasePage() {
		return this;
	}

	public Page getPage() {
		return page;
	}

	public LandingPage navigateToBasePage() {
		this.page.navigate(BASE_URL);
		return new LandingPage(this);
	}

	public void navigateTo(String url) {
		page.navigate(url);
	}
}
