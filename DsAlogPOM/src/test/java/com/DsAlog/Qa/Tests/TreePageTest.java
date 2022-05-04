package com.DsAlog.Qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.TreePage;

public class TreePageTest extends Baseclass {
	TreePage tp;

	@BeforeClass
	public void setup() throws InterruptedException {

		tp = new TreePage();

	}

	@Test(priority = 1, description = "Tree Flow Testing")
	public void TreeSelctionTest() {
		tp.dropTreeselection();
		String qtitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("ttitle"));

	}

	@Test(priority = 2,description = "TreePage Link Count")
	public void TreeLinkCountTest() {
		tp.TreeLinkCount();
	}

	@Test(priority = 3,description = "Overview of Trees Link Flow")
	public void TreeoverviewclickTest() {
		tp.treeoverviewclick();
		String qtitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("ttitle1"));

		tp.tryhereclick();
		String qttitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("ttitletry"));

		tp.tryeditortext();

		tp.navigateback();
		String ntitle = tp.TreePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("ttitle1"));
	}

	@Test(priority = 4,description = "Terminologies Link Flow")
	public void terminologieclickTest() {
		tp.terminologieclick();
		String qtitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("ttitle2"));

		tp.tryhereclick();
		String qttitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("ttitletry"));

		tp.tryeditortext();

		tp.navigateback();
		String ntitle = tp.TreePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("ttitle2"));
	}

	@Test(priority = 5,description = "Types of Trees Link Flow")
	public void treetypesclickTest() {
		tp.treetypesclick();
		String qtitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("ttitle3"));

		tp.tryhereclick();
		String qttitle = tp.TreePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("ttitletry"));

		tp.tryeditortext();

		tp.navigateback();
		String ntitle = tp.TreePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("ttitle3"));
	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
