package com.DsAlgo.Qa.Pages;

import static com.DsAlog.Qa.Utility.element_utility.gettitile;
import static com.DsAlog.Qa.Utility.element_utility.welehighlight;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlog.Qa.Utility.element_utility;

public class StackPage extends Baseclass {
	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//a[contains(text(),'Operations in Stack')]")
	WebElement operation;

	@FindBy(xpath = "//a[contains(text(),'Implementation')]")
	WebElement implementation;

	@FindBy(xpath = "//a[contains(text(),'Applications')]")
	WebElement application;

	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> slistcount;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;

	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;

	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropDataselection;
	
	@FindBy(xpath = "//a[contains(text(),'Stack')]")
	WebElement dpStack;

	// 2. Initializing Page Object

	public StackPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	
	public StackPage dropStackselection() {

		welehighlight(dropDataselection);
		dropDataselection.click();

		welehighlight(dpStack);
		dpStack.click();

		return new StackPage();

	}
	
	public String StackPageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}

	public void StackLinkCount() {
		int lcount = slistcount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = slistcount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public StackPage navigateback() {
		driver.navigate().back();
		return new StackPage();

	}

	public StackPage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new StackPage();

	}

	public StackPage tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();
		return new StackPage();

	}

	public StackPage operationclick() {
		element_utility.welehighlight(operation);
		operation.click();
		return new StackPage();
	}

	public StackPage implementationclick() {
		element_utility.welehighlight(implementation);
		implementation.click();
		return new StackPage();
	}

	public StackPage applicationclick() {
		element_utility.welehighlight(application);
		application.click();
		return new StackPage();
	}

}
