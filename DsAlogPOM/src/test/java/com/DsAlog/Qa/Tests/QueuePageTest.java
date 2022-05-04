package com.DsAlog.Qa.Tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.QueuePage;

public class QueuePageTest extends Baseclass {
	QueuePage qp;

	@BeforeClass
	public void setup() throws InterruptedException {

		qp = new QueuePage();

	}

	@Test(priority = 1, description = "Queue Flow Testing")
	public void QueueSelctionTest() {
		qp.dropQueueselection();
		String qtitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("qtitle"));

	}

	@Test(priority = 2,description = "Queue Page Link Count")
	public void QueueLinkCountTest() {
		qp.QueueLinkCount();
	}

	@Test(priority = 3,description = "Implementation of Queue in Python Link Flow")
	public void impQueueclickTest() {
		qp.impQueueclick();
		String qtitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("qtitle1"));

		qp.tryhereclick();
		String qttitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("qtitletry"));

		qp.tryeditortext();

		qp.navigateback();
		String ntitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("qtitle1"));

	}

	@Test(priority = 4,description = "Implementation using collections link Flow" )
	public void impcollectionsclickTest() {
		qp.impcollectionsclick();
		String qtitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("qtitle2"));

		qp.tryhereclick();
		String qttitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("qtitletry"));

		qp.tryeditortext();

		qp.navigateback();
		String ntitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("qtitle2"));

	}

	@Test(priority = 5,description = "Implementation using array" )
	public void imparrayclickTest() {
		qp.imparrayclick();
		String qtitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qtitle, prop.getProperty("qtitle3"));

		qp.tryhereclick();
		String qttitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("qtitletry"));

		qp.tryeditortext();

		qp.navigateback();
		String ntitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("qtitle3"));

	}

	@Test(priority = 6,description = "Queue Operations")
	public void QueueoperclickTest() {
		qp.Queueoperclick();
		String qot = qp.QueuePageTitleValidation();
		Assert.assertEquals(qot, prop.getProperty("qtitle4"));

		qp.tryhereclick();
		String qttitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(qttitle, prop.getProperty("qtitletry"));

		qp.tryeditortext();

		qp.navigateback();
		String ntitle = qp.QueuePageTitleValidation();
		Assert.assertEquals(ntitle, prop.getProperty("qtitle4"));

	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
