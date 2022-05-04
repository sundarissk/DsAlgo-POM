package com.DsAlgo.Qa.Pages;

import static com.DsAlog.Qa.Utility.element_utility.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlog.Qa.Utility.element_utility;

public class DataStructurePage extends Baseclass {
	@FindBy(xpath = "//a[contains(text(),'Time Complexity')]")
	WebElement complex;

	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;

	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> slistcount;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;

	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;
	@FindBy(xpath = "//div[@class='col'][1]//a")
	WebElement GetStartData;

	// 2. Initializing Page Object

	public DataStructurePage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public DataStructurePage getstartdatastructureselection() {
		element_utility.welehighlight(GetStartData);

		GetStartData.click();

		return new DataStructurePage();

	}

	public String DataStructurePageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}

	public void DataStructureLinkCount() {
		int lcount = slistcount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = slistcount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public DataStructurePage navigateback() {
		driver.navigate().back();
		return new DataStructurePage();

	}

	public DataStructurePage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new DataStructurePage();

	}

	public void tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();

	}

	public DataStructurePage timecomplexclick() {
		element_utility.welehighlight(complex);
		complex.click();
		return new DataStructurePage();

	}

}
