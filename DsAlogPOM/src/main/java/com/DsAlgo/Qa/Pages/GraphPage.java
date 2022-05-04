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

public class GraphPage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath ="//ul[2]//a[contains(text(),'Graph')]")
	WebElement graph;

	@FindBy(xpath = "//a[contains(text(),'Graph Representations')]")
	WebElement graphrep;

	@FindBy(xpath = "//a[contains(text(),'Graph')]")
	WebElement dpGraph;

	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> slistcount;

	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropDataselection;

	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;

	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;
	
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	WebElement signout;

	// 2. Initializing Page Object

	public GraphPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public GraphPage dropGraphselection() {

		welehighlight(dropDataselection);
		dropDataselection.click();

		welehighlight(dpGraph);
		dpGraph.click();

		return new GraphPage();

	}

	public String GraphPageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}

	public void GraphLinkCount() {
		int lcount = slistcount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = slistcount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public GraphPage navigateback() {
		driver.navigate().back();
		return new GraphPage();

	}

	public GraphPage graphclick() {
		element_utility.welehighlight(graph);
		graph.click();
		return new GraphPage();
	}

	public GraphPage graphrepclick() {
		element_utility.welehighlight(graphrep);
		graphrep.click();
		return new GraphPage();
	}

	public GraphPage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new GraphPage();

	}

	public GraphPage tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();
		return new GraphPage();

	}
	public HomePage signoutclick() {
		element_utility.welehighlight(signout);
		signout.click();
		return new HomePage();
	}

}
