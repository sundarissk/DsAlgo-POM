package com.DsAlog.Qa.Tests;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Pages.HomePage;
import com.DsAlgo.Qa.Pages.RegisterPage;

import com.DsAlgo.Qa.Pages.StartPage;
import com.DsAlog.Qa.Utility.ExcelUtil;


public class RegisterPageTest extends Baseclass {
	StartPage stp;
	RegisterPage rp;
	HomePage hp;
	public static String expath = "C:\\Users\\skuma\\eclipse-workspace\\DsAlogPOM\\src\\test\\resources\\TestData\\DsAlgoTD.xlsx";

	public RegisterPageTest() {
		super();
	}

	// 2. Browser initialization from TestBase & create object of startpage

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		initialization(browser);
		stp = new StartPage();
		rp = new RegisterPage();
		hp = new HomePage();

	}

	@Test(priority = 1, description = "Get Starting the Application")
	public void startpageTest() {
		stp.getstarthp();
		String stitle = stp.validateStartPageTitle();
		Assert.assertEquals(stitle, prop.getProperty("rtitle"));
		System.out.println(stitle);
	}

	@Test(priority = 2,description = "Opening Register Page to Register As a New Customer")
	public void registerpageTest() {
		stp.h_register();
		String rtitle = rp.validateRegisterPageTitle();
		Assert.assertEquals(rtitle, prop.getProperty("rtitle1"));
		System.out.println(rtitle);

	}

	@Test(priority = 3, dataProvider = "Signin details",description = "Register Flow Testing with invalid inputs")
	public void registerinputTest(String uname, String pword, String cpword) {
		hp = rp.register(uname, pword, cpword);
		String htitle = hp.validateHomePageTitle();
		System.out.println(htitle);
		Assert.assertEquals(htitle, prop.getProperty("rtitle"));

	}

	@DataProvider(name = "Signin details")
	public String[][] registerinput() throws IOException {

		String Logininput[][] = new String[2][3];
		for (int i = 1; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				Logininput[i - 1][j] = ExcelUtil.getCellData("TestData", i, j, expath);
			}
		}

		return Logininput;

	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
