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

public class LinkedListPage extends Baseclass {
	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//a[contains(text(),'Introduction')]")
	WebElement intro;

	@FindBy(xpath = "//a[contains(text(),'Creating Linked LIst')]")
	WebElement clinklist;

	@FindBy(xpath = "//a[contains(text(),'Types of Linked List')]")
	WebElement typeslinklist;

	@FindBy(xpath = "//a[contains(text(),'Implement Linked List in Python')]")
	WebElement implinklist;

	@FindBy(xpath = "//a[contains(text(),'Traversal')]")
	WebElement traversal;

	@FindBy(xpath = "//a[contains(text(),'Insertion')]")
	WebElement insertion;

	@FindBy(xpath = "//a[contains(text(),'Deletion')]")
	WebElement deletion;

	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> llistcount;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;

	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;

	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;

	@FindBy(xpath = "//a[contains(text(),'Linked List')]")
	WebElement dpLinkedList;

	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropdataselection;

	// 2. Initializing Page Object

	public LinkedListPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public LinkedListPage dropLinkedListselection() {
		welehighlight(dropdataselection);
		dropdataselection.click();

		welehighlight(dpLinkedList);
		dpLinkedList.click();

		return new LinkedListPage();

	}

	public void LListLinkCount() {
		int lcount = llistcount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = llistcount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public String LinkedListPageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}

	public LinkedListPage navigateback() {
		driver.navigate().back();
		return new LinkedListPage();

	}

	public LinkedListPage tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();
		return new LinkedListPage();
		

	}

	public LinkedListPage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new LinkedListPage();
		

	}

	public LinkedListPage introclick() {
		element_utility.welehighlight(intro);
		intro.click();
		return new LinkedListPage();
		
	}

	public LinkedListPage clinklistclick() {
		element_utility.welehighlight(clinklist);
		clinklist.click();
		return new LinkedListPage();
		
	}

	public LinkedListPage typeslinklist() {
		element_utility.welehighlight(typeslinklist);
		typeslinklist.click();
		return new LinkedListPage();
	}

	public LinkedListPage implinklistclick() {
		element_utility.welehighlight(implinklist);
		implinklist.click();
		return new LinkedListPage();
	}

	public LinkedListPage traversalclick() {
		element_utility.welehighlight(traversal);
		traversal.click();
		return new LinkedListPage();
	}

	public LinkedListPage insertionclick() {
		element_utility.welehighlight(insertion);
		insertion.click();
		return new LinkedListPage();
	}

	public LinkedListPage deletionclick() {
		element_utility.welehighlight(deletion);
		deletion.click();
		return new LinkedListPage();
	}

}
