package com.DsAlgo.Qa.Pages;

import static com.DsAlog.Qa.Utility.element_utility.*;

//import static com.DsAlog.Qa.Utility.element_utility.welehighlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.Qa.Base.Baseclass;

public class RegisterPage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository

	@FindBy(id = "id_username")
	WebElement txt_username;

	@FindBy(id = "id_password1")
	WebElement txt_password;

	@FindBy(id = "id_password2")
	WebElement txt_passwordconf;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement but_reg;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement but_linklogin;

	@FindBy(xpath = "//div[@class='navbar-nav']//ul//a[3]")
	WebElement but_signin;

	// 2. Initializing Page Object

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	public HomePage register(String uname, String pword, String cpword) {
		// element_utility.welehighlight(driver, but_register);
		// but_register.click();

		welehighlight(txt_username);
		txt_username.sendKeys(uname);

		welehighlight(txt_password);
		txt_password.sendKeys(pword);

		welehighlight(txt_passwordconf);
		txt_passwordconf.sendKeys(cpword);

		welehighlight(but_reg);
		but_reg.click();

		return new HomePage();

	}

	public String validateRegisterPageTitle() {

		String hptitle = gettitile();
		System.out.println("Title:" + hptitle);

		return hptitle;
	}

	public SigningPage login_already() {
		welehighlight(but_linklogin);
		but_linklogin.click();
		return new SigningPage();
	}

	public SigningPage signin() {
		welehighlight(but_signin);
		but_signin.click();
		return new SigningPage();

	}

}
