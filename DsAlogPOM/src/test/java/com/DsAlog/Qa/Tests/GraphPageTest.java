package com.DsAlog.Qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.GraphPage;

public class GraphPageTest extends Baseclass {
	GraphPage gp;

	@BeforeClass
	public void setup() throws InterruptedException {

		gp = new GraphPage();

	}

	@Test(priority = 1, description = "Graph Flow Testing")
	public void GraphSelctionTest() {
		gp.dropGraphselection();
		String qtitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("gtitle"));

	}

	@Test(priority = 2,description = "Graph Page Link Count")
	public void GraphLinkCountTest() {
		gp.GraphLinkCount();
	}

	@Test(priority = 3,description = "Graph Link Flow")
	public void graphclickTest() {
		gp.graphclick();
		String qtitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("gtitle1"));

		gp.tryhereclick();
		String qttitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("gtitletry"));

		gp.tryeditortext();

		gp.navigateback();
		String ntitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("gtitle1"));
	}

	@Test(priority = 4, description = "Graph Representations Link Flow")
	public void graphrepclickTest() {
		gp.graphrepclick();
		String qtitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("gtitle2"));

		gp.tryhereclick();
		String qttitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("gtitletry"));

		gp.tryeditortext();

		gp.navigateback();
		String ntitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("gtitle2"));
	}
	@Test(priority = 5 , description = "Final SignOut of the Application")
	public void SignOutTest() {
		gp.signoutclick();
		String htitle = gp.GraphPageTitleValidation();
		Assert.assertEquals(htitle, "NumpyNinja");
	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

	// 4. Closing Browser
	@AfterClass
	public void closing() throws InterruptedException {
		// driver.close();
		driver.quit();

	}

}
