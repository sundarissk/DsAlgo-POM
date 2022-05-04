package com.DsAlgo.Qa.Pages;

import static com.DsAlog.Qa.Utility.element_utility.gettitile;
import static com.DsAlog.Qa.Utility.element_utility.welehighlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.Qa.Base.Baseclass;

public class SigningPage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(id = "id_username")
	WebElement txt_username_sp;

	@FindBy(id = "id_password")
	WebElement txt_password_sp;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement but_login_sp;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement but_register_sp;

	// 2. Initializing Page Object
	public SigningPage() {

		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public HomePage signing_sp(String sname, String spassw) throws InterruptedException {

		welehighlight(txt_username_sp);
		txt_username_sp.sendKeys(sname);

		welehighlight(txt_password_sp);
		txt_password_sp.sendKeys(spassw);

		welehighlight(but_login_sp);
		but_login_sp.click();

		return new HomePage();

	}

	public RegisterPage register_sp() {
		welehighlight(but_register_sp);
		but_register_sp.click();
		return new RegisterPage();

	}

	public String validateSigninPageTitle() {

		String hptitle = gettitile();
		System.out.println("Title:" + hptitle);

		return hptitle;
	}

}
