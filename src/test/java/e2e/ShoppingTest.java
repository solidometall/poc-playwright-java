package e2e;

import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.LandingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShoppingTest extends TestBase {
	LandingPage storeLandingPage;

	@BeforeMethod
	public void configTests() {
		storeLandingPage = basePage.navigateToBasePage();
	}

	@Test(groups = { "regression", "cart" })
	public void addExistingItemToCart() {
		var firstItemName = "Unusable Security";
		var secondItemName = "Experimental";
		var itemQuantity = 1;
		var totalItems = 2;

		// add items to cart
		storeLandingPage.addItemToCart(firstItemName, itemQuantity);
		storeLandingPage.addItemToCart(secondItemName, itemQuantity);

		// validate cart quantity
		assertThat(storeLandingPage.cartQuantity).hasText(String.valueOf(totalItems));
	}

	@Test(groups = { "regression", "checkout" })
	public void addItemToCartAndProceedToCheckout() {
		var itemName = "Unusable Security";
		var itemQuantity = 3;

		// add item to cart & then proceed to checkout
		storeLandingPage.addItemToCart(itemName, itemQuantity);
		var checkout = storeLandingPage.proceedToCheckout();

		// validate item name & quantity
		assertThat(checkout.productName).containsText(itemName);
		assertThat(checkout.productQuantityText).containsText(String.valueOf(itemQuantity));
	}
}
