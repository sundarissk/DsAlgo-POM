package com.DsAlog.Qa.Tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;

import com.DsAlgo.Qa.Pages.StackPage;

public class StackPageTest extends Baseclass {

	StackPage sp;

	@BeforeClass
	public void setup() throws InterruptedException {

		sp = new StackPage();

	}

	@Test(priority = 1, description = "Stack Flow Testing")
	public void dropStackselectionTest() {
		sp.dropStackselection();
		String atitle = sp.StackPageTitleValidation();
		Assert.assertEquals(atitle, "Stack");
	}

	@Test(priority = 2,description = "Count total Links in StackPage")
	public void StackLinkCountTest() {
		sp.StackLinkCount();
	}

	@Test(priority = 3,description = "Operations in Stack Link Flow")
	public void operationclickTest() {
		sp.operationclick();
		String atitle = sp.StackPageTitleValidation();
		Assert.assertEquals(atitle, "Operations in Stack");

		sp.tryhereclick();
		String thtitle = sp.StackPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		sp.tryeditortext();

		sp.navigateback();
		String nvtitle = sp.StackPageTitleValidation();
		Assert.assertEquals(nvtitle, "Operations in Stack");
	}

	@Test(priority = 4,description = "Implementation Link Flow")
	public void implementationclickTest() {
		sp.implementationclick();
		String atitle = sp.StackPageTitleValidation();
		Assert.assertEquals(atitle, "Implementation");

		sp.tryhereclick();
		String thtitle = sp.StackPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		sp.tryeditortext();

		sp.navigateback();
		String nvtitle = sp.StackPageTitleValidation();
		Assert.assertEquals(nvtitle, "Implementation");
	}

	@Test(priority = 5,description = "Applications Link Flow")
	public void applicationclickTest() {
		sp.applicationclick();
		String atitle = sp.StackPageTitleValidation();
		Assert.assertEquals(atitle, "Applications");

		sp.tryhereclick();
		String thtitle = sp.StackPageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");
		sp.tryeditortext();

		sp.navigateback();
		String nvtitle = sp.StackPageTitleValidation();
		Assert.assertEquals(nvtitle, "Applications");
	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}
}
