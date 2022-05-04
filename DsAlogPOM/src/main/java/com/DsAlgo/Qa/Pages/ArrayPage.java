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

public class ArrayPage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//a[contains(text(),'Arrays in Python')]")
	WebElement linkpython;

	@FindBy(xpath = "//a[contains(text(),'Arrays Using List')]")
	WebElement linkusinglist;

	@FindBy(xpath = "//a[contains(text(),'Basic Operations in Lists')]")
	WebElement linkoperationslist;

	@FindBy(xpath = "//a[contains(text(),'Applications of Array')]")
	WebElement linkarray;

	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;

	// @FindBy(xpath = "//textarea[@id='editor']")
	// WebElement textarea;

	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;

	

	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> listcount;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropDataselection;
	
	@FindBy(xpath = "//a[contains(text(),'Arrays')]")
	WebElement dpArray;

	// 2. Initializing Page Object
	public ArrayPage() {

		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	
	public ArrayPage Arrayselection() {

		welehighlight(dropDataselection);
		dropDataselection.click();

		welehighlight(dpArray);
		dpArray.click();

		return new ArrayPage();

	}

	public String ArraypageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}

	public void APageLinkCount() {
		int lcount = listcount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = listcount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public ArrayPage linkpythonclick() {
		element_utility.welehighlight(linkpython);
		linkpython.click();
		return new ArrayPage();

	}

	public ArrayPage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new ArrayPage();

	}

	public ArrayPage tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();
		return new ArrayPage();

	}

	public ArrayPage navigateback() {
		driver.navigate().back();
		return new ArrayPage();

	}

	public ArrayPage linkusinglist() {
		element_utility.welehighlight(linkusinglist);
		linkusinglist.click();
		return new ArrayPage();

	}

	public ArrayPage linkoperationslist() {
		element_utility.welehighlight(linkoperationslist);
		linkoperationslist.click();
		return new ArrayPage();

	}

	public ArrayPage linkarray() {
		element_utility.welehighlight(linkarray);
		linkarray.click();
		return new ArrayPage();

	}

}
