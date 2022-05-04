package com.DsAlog.Qa.Tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.ArrayPage;

public class ArrayPageTest extends Baseclass {

	ArrayPage ap;

	@BeforeClass
	public void setup() throws InterruptedException {

		ap = new ArrayPage();

	}

	@Test(priority = 1, description = "Array Flow Teting")

	public void ArraySelectionTest() {

		ap = ap.Arrayselection();
		String atitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(atitle, "Array");

	}

	@Test(priority = 2, description = "Counting Array Page total Links ")

	public void APageModuleCountTest() {

		ap.APageLinkCount();
	}

	@Test(priority = 3, description = "Arrays in Python Links Flow")
	public void linkpythonclickTest() {

		ap.linkpythonclick();
		String ltitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(ltitle, "Arrays in Python");

		ap.tryhereclick();
		String thtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(thtitle, "Assessment");

		ap.tryeditortext();

		ap.navigateback();
		String nvtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(nvtitle, "Arrays in Python");

	}

	@Test(priority = 4,  description = "Arrays Using List Links Flow")
	public void linkusinglistTest() {
		ap.linkusinglist();
		String utitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(utitle, "Arrays Using List");

		ap.tryhereclick();
		String uhtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(uhtitle, "Assessment");
		ap.tryeditortext();

		ap.navigateback();
		String unvtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(unvtitle, "Arrays Using List");

	}

	@Test(priority = 5, description = "Basic Operations in Lists Links Flow")
	public void linkoperationslistTest() {
		ap.linkoperationslist();
		String otitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(otitle, "Basic Operations in Lists");

		ap.tryhereclick();
		String othtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(othtitle, "Assessment");
		ap.tryeditortext();

		ap.navigateback();
		String onvtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(onvtitle, "Basic Operations in Lists");
	}

	@Test(priority = 6, description = "Applications of Array Links Flow")
	public void linkarrayTest() {
		ap.linkarray();
		String aytitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(aytitle, "Applications of Array");

		ap.tryhereclick();
		String athtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(athtitle, "Assessment");
		ap.tryeditortext();

		ap.navigateback();
		String anvtitle = ap.ArraypageTitleValidation();
		Assert.assertEquals(anvtitle, "Applications of Array");

	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
