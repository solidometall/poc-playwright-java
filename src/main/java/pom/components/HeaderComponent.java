package pom.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.BasePage;

public class HeaderComponent extends BasePage {

	public final Locator signInBtn;
	public final Locator signUpBtn;

	public HeaderComponent(BasePage basePage) {
		super(basePage.getPage());

		// locators
		this.signInBtn = page.getByText("Sign in");
		this.signUpBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create User"));
	}
}
