package e2e;

import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.LandingPage;
import utils.TestUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends TestBase {
	LandingPage storeLandingPage;

	@BeforeMethod
	public void configTests() {
		storeLandingPage = basePage.navigateToBasePage();
	}

	@Test(groups = { "regression", "login" })
	public void loginWithNonExistingUser() {
		var username = "John Doe";
		var password = "123456";

		// login
		var loginPage = storeLandingPage.proceedToLogIn();
		loginPage.doLogin(username, password);

		// validate error message visibility
		assertThat(loginPage.loginError).isVisible();
	}

	@Test(groups = { "regression", "signup" })
	public void signupNewUser() {
		var username = "Automation User ".concat(TestUtils.currentTimestamp);
		var password = "123456";

		// login
		var loginPage = storeLandingPage.proceedToSignUp();
		loginPage.doSignUp(username, password);

		// validate successful user creation
		assertThat(loginPage.loginSuccess).isVisible();
		assertThat(loginPage.continueShoppingBtn).isVisible();
	}
}
