package com.DsAlog.Qa.Tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;

import com.DsAlgo.Qa.Pages.LinkedListPage;

public class LinkedListPageTest extends Baseclass {

	LinkedListPage lp;

	@BeforeClass
	public void setup() throws InterruptedException {

		lp = new LinkedListPage();

	}

	@Test(priority = 1, description = "LinkedList Flow Testing")
	public void dropLinkedListselectionTest() {
		lp = lp.dropLinkedListselection();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Linked List");
	}

	@Test(priority = 2, description = "LinkedList Link Count")
	public void LListLinkCountTest() {
		lp.LListLinkCount();
	}

	@Test(priority = 3, description = "Introduction Link Flow")
	public void introclickTest() {
		lp.introclick();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Introduction");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Introduction");
	}

	@Test(priority = 4, description = "Creating Linked List Link Flow")
	public void clinklistclickTest() {

		lp.clinklistclick();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Creating Linked LIst");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Creating Linked LIst");

	}

	@Test(priority = 5,description = "Types of Linked List Link Flow")
	public void typeslinklistTest() {

		lp.typeslinklist();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Types of Linked List");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Types of Linked List");

	}

	@Test(priority = 6, description = "Implement Linked List in Python Link Flow")
	public void implinklistclickTest() {

		lp.implinklistclick();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Implement Linked List in Python");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Implement Linked List in Python");

	}

	@Test(priority = 7, description = "Traversal Link Flow")
	public void traversalclickTest() {

		lp.traversalclick();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Traversal");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Traversal");

	}

	@Test(priority = 8,description = "Insertion Link Flow")
	public void insertionclickTest() {

		lp.insertionclick();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Insertion");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Insertion");

	}

	@Test(priority = 9,description = "Deletion Link Flow")
	public void deletionclickTest() {

		lp.deletionclick();
		String atitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(atitle, "Deletion");

		lp.tryhereclick();
		String thtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		lp.tryeditortext();

		lp.navigateback();
		String nvtitle = lp.LinkedListPageTitleValidation();
		Assert.assertEquals(nvtitle, "Deletion");

	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
