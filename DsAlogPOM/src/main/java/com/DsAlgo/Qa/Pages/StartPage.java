package com.DsAlgo.Qa.Pages;

import static com.DsAlog.Qa.Utility.element_utility.gettitile;
import static com.DsAlog.Qa.Utility.element_utility.welehighlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.Qa.Base.Baseclass;


public class StartPage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//button[@class='btn']")
	WebElement getstart;

	@FindBy(xpath = "//div[@class='navbar-nav']//ul//a[2]")
	WebElement but_hregister;

	@FindBy(xpath = "//div[@class='navbar-nav']//ul//a[3]")
	WebElement but_hsignin;

	// 2. Initializing Page Object
	public StartPage() {

		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	public void getstarthp() {
		welehighlight(getstart);
		getstart.click();

	}

	public String validateStartPageTitle() {

		String hptitle = gettitile();
		System.out.println("Title:" + hptitle);

		return hptitle;
	}

	public RegisterPage h_register() {
		welehighlight(but_hregister);
		but_hregister.click();
		return new RegisterPage();
	}

	public SigningPage h_signin() throws InterruptedException {
	
		welehighlight(but_hsignin);
		but_hsignin.click();
		return new SigningPage();
	}

}
