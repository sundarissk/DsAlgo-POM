package com.DsAlog.Qa.Tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.ArrayPage;
import com.DsAlgo.Qa.Pages.HomePage;
import com.DsAlgo.Qa.Pages.RegisterPage;
import com.DsAlgo.Qa.Pages.SigningPage;
import com.DsAlgo.Qa.Pages.StartPage;

import com.DsAlog.Qa.Utility.ExcelUtil;
import com.DsAlog.Qa.Utility.TestData;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

public class SigninPageTest extends Baseclass {

	StartPage stpage;
	RegisterPage rpage;
	SigningPage snpage;
	HomePage hpage;
	TestData td;

	ArrayPage ap;

	public static String expath = "C:\\Users\\skuma\\eclipse-workspace\\DsAlogPOM\\src\\test\\resources\\TestData\\DsAlgoTD.xlsx";

	@BeforeClass
	public void setup() throws InterruptedException {

		rpage = new RegisterPage();
		snpage = new SigningPage();
		hpage = new HomePage();
		td = new TestData();

	}

	@Test(priority = 1 , description = "Signing Flow Testing")
	public void registerpageTest() {
		rpage.login_already();
		String stitle = snpage.validateSigninPageTitle();
		Assert.assertEquals(stitle, "Login");

	}

	@Test(priority = 2, dataProvider = "Signin details",description = "Signin with Valid Inputs")
	public void signinpageTest(String sname, String pword) throws InterruptedException {

		snpage.signing_sp(sname, pword);
		hpage.validateHomePageTitle();

	}

	@Test(priority = 3,description = "Count total module in HomePage")
	public void HPModuleCountTest() {
		hpage.HPModuleCount();
	}

	@DataProvider(name = "Signin details")
	public Object[][] registerinput() throws IOException {

		String name = ExcelUtil.getCellData("TestData", 1, 4, expath);
		String pword = ExcelUtil.getCellData("TestData", 1, 5, expath);

		return new Object[][] { { name, pword } };

	}

	@DataProvider(name = "Poiji")
	public Object[][] registerinputpoiji() {

		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetName("TestData").build();
		List<TestData> tdv = Poiji.fromExcel(new File(
				"C:\\Users\\skuma\\eclipse-workspace\\DsAlogPOM\\src\\test\\resources\\TestData\\DsAlgoData.xls"),
				TestData.class, options);

		String sname = tdv.get(0).getSname();
		String pword = tdv.get(0).getSpword();

		return new Object[][] { { sname, pword } };

	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
