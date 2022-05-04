package com.DsAlog.Qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.DataStructurePage;
import com.DsAlgo.Qa.Pages.HomePage;

public class DataStructurePageTest extends Baseclass {
	HomePage hpage;
	DataStructurePage ds;

	@BeforeClass
	public void setup() throws InterruptedException {

		hpage = new HomePage();
		ds = new DataStructurePage();

	}

	@Test(priority = 1,description = "Data structure Flow Testing")
	public void getstartdsselectionTest() {
		ds.getstartdatastructureselection();
		String dstitle = ds.DataStructurePageTitleValidation();
		Assert.assertEquals(dstitle, "Data Structures-Introduction");
	}

	@Test(priority = 2, description = "Data Structure Page Link Count")
	public void DataStructureLinkCountTest() {

		ds.DataStructureLinkCount();
	}

	@Test(priority = 3,description = "Time Complexity Link Flow")
	public void timecomplexclickTest() {
		ds.timecomplexclick();
		String tdstitle = ds.DataStructurePageTitleValidation();
		Assert.assertEquals(tdstitle, "Time Complexity");

		ds.tryhereclick();
		String thtitle = ds.DataStructurePageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");

		ds.tryeditortext();
		String dstitle = ds.DataStructurePageTitleValidation();
		Assert.assertEquals(dstitle, "Assessment");

		ds.navigateback();
		String tbstitle = ds.DataStructurePageTitleValidation();
		Assert.assertEquals(tbstitle, "Time Complexity");

	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}
}
