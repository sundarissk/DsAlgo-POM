package com.DsAlgo.Qa.Pages;

import static com.DsAlog.Qa.Utility.element_utility.gettitile;
import static com.DsAlog.Qa.Utility.element_utility.welehighlight;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlog.Qa.Utility.element_utility;

public class HomePage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	WebElement bt_singnout;

	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropdataselection;

	@FindBy(xpath = "//div[@class='col'][1]//a")
	WebElement GetStartData;

	@FindBy(xpath = "//div[@class='col'][2]//a")
	WebElement GetStartArray;

	@FindBy(xpath = "//div[@class='col'][3]//a")
	WebElement GetStartLinkedList;

	@FindBy(xpath = "//div[@class='col'][4]//a")
	WebElement GetStartStack;

	@FindBy(xpath = "//div[@class='col'][5]//a")
	WebElement GetStartQueue;

	@FindBy(xpath = "//div[@class='col'][6]//a")
	WebElement GetStartTree;

	@FindBy(xpath = "//div[@class='col'][7]//a")
	WebElement GetStartGraph;

	@FindBy(xpath = "//a[contains(text(),'Queue')]")
	WebElement dpqueue;

	@FindBy(xpath = "//a[contains(text(),'Arrays')]")
	WebElement dpArray;

	@FindBy(xpath = "//a[contains(text(),'Linked List')]")
	WebElement dpLinkedList;

	@FindBy(xpath = "//a[contains(text(),'Stack')]")
	WebElement dpStack;

	@FindBy(xpath = "//a[contains(text(),'Tree')]")
	WebElement dpTree;

	@FindBy(xpath = "//a[contains(text(),'Graph')]")
	WebElement dpGraph;

	@FindBys(@FindBy(xpath = "//h5[@class='card-title']"))
	List<WebElement> modulecount;

	// 2. Initializing Page Object

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public String validateHomePageTitle() {

		String hptitle = gettitile();
		System.out.println("Title:" + hptitle);

		return hptitle;
	}

	public void HPModuleCount() {
		System.out.println("Module count : " + modulecount.size());
		for (int i = 0; i < modulecount.size(); i++) {
			String vlaue = modulecount.get(i).getText();
			System.out.println("Module " + i + " :" + vlaue);
		}
	}

	// Backupcode for count
	public void HomePageModuleCount() {

		List<WebElement> module = driver.findElements(By.xpath("//h5[@class='card-title']"));
		// int mcount = module.size();
		System.out.println("List count : " + module.size());
		for (int i = 0; i < module.size(); i++) {
			String vlaue = modulecount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public ArrayPage dropArrayselection() {
		welehighlight(dropdataselection);
		dropdataselection.click();
		welehighlight(dpArray);
		dpArray.click();

		return new ArrayPage();

	}

	public LinkedListPage dropLinkedListselection() {
		welehighlight(dropdataselection);
		dropdataselection.click();

		welehighlight(dpLinkedList);
		dpLinkedList.click();

		return new LinkedListPage();

	}

	public StackPage dropStackselection() {

		welehighlight(dropdataselection);
		dropdataselection.click();

		welehighlight(dpStack);
		dpStack.click();

		return new StackPage();

	}

	public QueuePage dropQueueselection() {

		welehighlight(dropdataselection);
		dropdataselection.click();

		welehighlight(dpqueue);
		dpqueue.click();

		return new QueuePage();

	}

	public TreePage dropTreeselection() {

		welehighlight(dropdataselection);
		dropdataselection.click();

		welehighlight(dpTree);
		dpTree.click();

		return new TreePage();

	}

	public GraphPage dropGraphselection() {

		welehighlight(dropdataselection);
		dropdataselection.click();

		welehighlight(dpGraph);
		dpGraph.click();

		return new GraphPage();

	}

	public DataStructurePage getstartdatastructureselection() {
		element_utility.welehighlight(GetStartData);

		GetStartData.click();

		return new DataStructurePage();

	}

	public ArrayPage getstartArrayselection() {

		GetStartArray.click();

		return new ArrayPage();

	}

	public LinkedListPage getstartLinkedListselection() {

		GetStartLinkedList.click();

		return new LinkedListPage();

	}

	public StackPage getstartStackselection() {

		GetStartStack.click();

		return new StackPage();

	}

	public QueuePage getstartQueueselection() {

		GetStartQueue.click();

		return new QueuePage();

	}

	public TreePage getstartTreeselection() {

		GetStartTree.click();

		return new TreePage();

	}

	public GraphPage getstartGraphselection() {

		GetStartGraph.click();

		return new GraphPage();

	}

}
