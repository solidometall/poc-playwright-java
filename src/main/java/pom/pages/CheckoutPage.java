package pom.pages;

import com.microsoft.playwright.Locator;
import config.BasePage;

public class CheckoutPage extends BasePage {

	public final Locator productName;
	public final Locator productQuantityText;

	public CheckoutPage(BasePage basePage) {
		super(basePage.getPage());
		this.productName = page.locator(".columnCenter>div:nth-child(1)");
		this.productQuantityText = page.locator(".columnCenter>div:nth-child(2)");
	}
}
