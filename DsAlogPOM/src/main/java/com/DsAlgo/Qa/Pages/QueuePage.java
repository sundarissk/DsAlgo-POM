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

public class QueuePage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//a[contains(text(),'Implementation of Queue in Python')]")
	WebElement impQueue;

	@FindBy(xpath = "//a[contains(text(),'Implementation using collections.deque')]")
	WebElement impcollections;

	@FindBy(xpath = "//a[contains(text(),'Implementation using array')]")
	WebElement imparray;
	
	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> slistcount;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropDataselection;

	@FindBy(xpath = "//a[contains(text(),'Queue Operations')]")
	WebElement Queueoper;
	
	@FindBy(xpath = "//a[contains(text(),'Queue')]")
	WebElement dpQueue;
	
	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;


	// 2. Initializing Page Object

	public QueuePage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	
	public QueuePage dropQueueselection() {

		welehighlight(dropDataselection);
		dropDataselection.click();

		welehighlight(dpQueue);
		dpQueue.click();

		return new QueuePage();

	}
	
	public String QueuePageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}
	public QueuePage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new QueuePage();

	}

	public QueuePage tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();
		return new QueuePage();

	}

	public void QueueLinkCount() {
		int lcount = slistcount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = slistcount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public QueuePage impQueueclick() {
		element_utility.welehighlight(impQueue);
		impQueue.click();
		return new QueuePage();
	}

	public QueuePage impcollectionsclick() {
		element_utility.welehighlight(impcollections);
		impcollections.click();
		return new QueuePage();
	}
	
	public QueuePage navigateback() {
		driver.navigate().back();
		return new QueuePage();

	}

	public QueuePage imparrayclick() {
		element_utility.welehighlight(imparray);
		imparray.click();
		return new QueuePage();
	}

	public QueuePage Queueoperclick() {
		element_utility.welehighlight(Queueoper);
		Queueoper.click();
		return new QueuePage();
	}
}
