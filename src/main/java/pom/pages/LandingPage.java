package pom.pages;

import com.microsoft.playwright.Locator;
import config.BasePage;
import pom.components.HeaderComponent;

public class LandingPage extends BasePage {

	public final HeaderComponent header;
	public final Locator title;
	public final Locator addToCartBtn;
	public final Locator checkoutBtn;
	public final Locator productGrid;
	public final Locator productCards;
	public final Locator cartQuantity;

	public LandingPage(BasePage basePage) {
		super(basePage.getPage());
		this.header = new HeaderComponent(basePage);

		// locators
		this.title = page.locator(".headerTitle");
		this.addToCartBtn = page.locator(".tileAdd");
		this.checkoutBtn = page.locator(".checkout-button");
		this.productGrid = page.locator(".productListWrapper");
		this.productCards = page.locator(".tile");
		this.cartQuantity = page.locator(".cartDigit");
	}

	public void addItemToCart(String itemName, int quantity) {
		this.productCards
			.filter(new Locator.FilterOptions().setHasText(itemName))
			.locator(this.addToCartBtn)
			.click(new Locator.ClickOptions().setClickCount(quantity));
	}

	public CheckoutPage proceedToCheckout() {
		this.checkoutBtn.click();
		return new CheckoutPage(super.getBasePage());
	}

	public LoginPage proceedToLogIn() {
		this.header.signInBtn.click();
		return new LoginPage(super.getBasePage());
	}

	public LoginPage proceedToSignUp() {
		this.header.signUpBtn.click();
		return new LoginPage(super.getBasePage());
	}
}
