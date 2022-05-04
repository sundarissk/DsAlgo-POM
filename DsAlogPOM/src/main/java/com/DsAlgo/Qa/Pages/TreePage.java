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

public class TreePage extends Baseclass {

	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//a[contains(text(),'Overview of Trees')]")
	WebElement treeoverview;

	@FindBy(xpath = "//a[contains(text(),'Terminologies')]")
	WebElement terminologie;

	@FindBy(xpath = "//a[contains(text(),'Types of Trees')]")
	WebElement treetypes;

	@FindBy(xpath = "//ul[4]//a[contains(text(),'Tree Traversals')]")
	WebElement treetraversals;

	@FindBy(xpath = "//ul//a[contains(text(),'Traversals-Illustration')]")
	WebElement traversalillut;

	@FindBy(xpath = "//ul[6]//a[contains(text(),'Binary Trees')]")
	WebElement binarytree;

	@FindBy(xpath = "//ul//a[contains(text(),'Types of Binary Trees')]")
	WebElement binarytyes;

	@FindBy(xpath = "//ul//a[contains(text(),'Implementation in Python')]")
	WebElement pythonimpl;

	@FindBy(xpath = "//ul//a[contains(text(),'Binary Tree Traversals')]")
	WebElement binarytraversal;

	@FindBy(xpath = "//ul//a[contains(text(),'Implementation of Binary Trees')]")
	WebElement binaryimp;

	@FindBy(xpath = "//ul//a[contains(text(),'Applications of Binary trees')]")
	WebElement binaryappli;

	@FindBy(xpath = "//ul//a[contains(text(),'Binary Search Trees')]")
	WebElement binarysearch;

	@FindBy(xpath = "//ul//a[contains(text(),'Implementation Of BST')]")
	WebElement bstimp;

	@FindBys(@FindBy(xpath = "//ul//a[@class='list-group-item']"))
	List<WebElement> treecount;

	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;

	@FindBy(xpath = "//textarea[@autocorrect='off']")
	WebElement textarea;

	@FindBy(xpath = "//button[@type='button']")
	WebElement btnrun;

	@FindBy(xpath = "//a[contains(@class,'nav-link dropdown-toggle')]")
	WebElement dropdataselection;

	@FindBy(xpath = "//a[contains(text(),'Tree')]")
	WebElement dpTree;

	// 2. Initializing Page Object

	public TreePage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public TreePage dropTreeselection() {
		welehighlight(dropdataselection);
		dropdataselection.click();
		welehighlight(dpTree);
		dpTree.click();

		return new TreePage();

	}

	public String TreePageTitleValidation() {
		String title = gettitile();
		System.out.println("Title : " + title);
		return title;

	}

	public void TreeLinkCount() {
		int lcount = treecount.size();
		System.out.println("List count : " + lcount);
		for (int i = 0; i < lcount; i++) {
			String vlaue = treecount.get(i).getText();
			System.out.println("List " + i + " :" + vlaue);
		}
	}

	public TreePage treeoverviewclick() {
		element_utility.welehighlight(treeoverview);
		treeoverview.click();
		return new TreePage();
	}

	public TreePage terminologieclick() {
		element_utility.welehighlight(terminologie);
		terminologie.click();
		return new TreePage();

	}

	public TreePage treetypesclick() {
		element_utility.welehighlight(treetypes);
		treetypes.click();
		return new TreePage();
	}

	public TreePage navigateback() {
		driver.navigate().back();
		return new TreePage();

	}

	public TreePage treetraversclick() {
		element_utility.welehighlight(treetraversals);
		treetraversals.click();
		return new TreePage();
	}

	public TreePage traversalillutclick() {
		element_utility.welehighlight(traversalillut);
		traversalillut.click();
		return new TreePage();
	}

	public TreePage binarytreeclick() {
		element_utility.welehighlight(binarytree);
		binarytree.click();
		return new TreePage();
	}

	public TreePage binarytyesclick() {
		element_utility.welehighlight(binarytyes);
		binarytyes.click();
		return new TreePage();
	}

	public TreePage pythonimplclick() {
		element_utility.welehighlight(pythonimpl);
		pythonimpl.click();
		return new TreePage();
	}

	public TreePage binarytraversalclick() {
		element_utility.welehighlight(binarytraversal);
		binarytraversal.click();
		return new TreePage();
	}

	public TreePage binaryimpclick() {
		element_utility.welehighlight(binaryimp);
		binaryimp.click();
		return new TreePage();
	}

	public TreePage binaryappliclick() {
		element_utility.welehighlight(binaryappli);
		binaryappli.click();
		return new TreePage();
	}

	public TreePage binarysearchclick() {
		element_utility.welehighlight(binarysearch);
		binarysearch.click();
		return new TreePage();
	}

	public TreePage bstimpclick() {
		element_utility.welehighlight(bstimp);
		bstimp.click();
		return new TreePage();
	}

	public TreePage tryhereclick() {
		element_utility.welehighlight(tryhere);
		tryhere.click();
		return new TreePage();

	}

	public TreePage tryeditortext() {

		textarea.sendKeys("print 10");
		element_utility.welehighlight(btnrun);
		btnrun.click();
		return new TreePage();

	}
}
