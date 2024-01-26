package config;

import com.microsoft.playwright.Page;
import pom.pages.LandingPage;

import static utils.BrowserUtils.getBaseURL;

public class BasePage {

	protected String BASE_URL;
	protected Page page;

	public BasePage(Page page) {
		this.page = page;
		this.BASE_URL = getBaseURL();
	}

	public BasePage getBasePage() {
		return this;
	}

	public Page getPage() {
		return page;
	}

	public LandingPage navigateToBasePage() {
		this.page.navigate(this.BASE_URL);
		return new LandingPage(this);
	}
}
