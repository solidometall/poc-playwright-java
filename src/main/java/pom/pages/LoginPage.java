package pom.pages;

import com.microsoft.playwright.Locator;
import config.BasePage;

public class LoginPage extends BasePage {
	public Locator username;
	public Locator password;
	public Locator proceedLogInFormBtn;
	public Locator proceedSignUpFormBtn;
	public Locator continueShoppingBtn;
	public Locator loginError;
	public Locator loginSuccess;

	public LoginPage(BasePage basePage) {
		super(basePage.getPage());

		// locators
		this.username = page.locator("//input[@name='username']");
		this.password = page.locator("//input[@name='password']");
		this.proceedLogInFormBtn = page.locator(".loginFormButton>button");
		this.proceedSignUpFormBtn = page.locator(".createFormButton>button");
		this.continueShoppingBtn = page.locator(".successButton>button");
		this.loginError = page.locator(".errorMessage");
		this.loginSuccess = page.locator(".successMessage");
	}

	public void doLogin(String username, String password) {
		this.username.fill(username);
		this.password.fill(password);
		this.proceedLogInFormBtn.click();
	}

	public void doSignUp(String username, String password) {
		this.username.fill(username);
		this.password.fill(password);
		this.proceedSignUpFormBtn.click();
	}
}
