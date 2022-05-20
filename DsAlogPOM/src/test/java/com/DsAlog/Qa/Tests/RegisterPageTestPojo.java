package com.DsAlog.Qa.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Qa.Base.Baseclass;
import com.DsAlgo.Qa.Base.RegisterPojo;
import com.DsAlgo.Qa.Pages.HomePage;
import com.DsAlgo.Qa.Pages.RegisterPage;

import com.DsAlgo.Qa.Pages.StartPage;
import com.DsAlog.Qa.Utility.ExcelUtil;

public class RegisterPageTestPojo extends Baseclass {
	StartPage stp;
	RegisterPage rp;
	HomePage hp;
	public static String expath = "C:\\Users\\skuma\\eclipse-workspace\\DsAlogPOM\\src\\test\\resources\\TestData\\DsAlgoTD.xlsx";

	public String sheetname = "TestData";

	public RegisterPageTestPojo() {
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

	@Test(priority = 2, description = "Opening Register Page to Register As a New Customer")
	public void registerpageTest() {
		stp.h_register();
		String rtitle = rp.validateRegisterPageTitle();
		Assert.assertEquals(rtitle, prop.getProperty("rtitle1"));
		System.out.println(rtitle);

	}

	@Test(priority = 3, dataProvider = "Signin details", description = "Register Flow Testing with invalid inputs")
	public void registerinputTest(RegisterPojo jo) throws InterruptedException {

		String uname = jo.getUname();
		String pword = jo.getPword();
		String cword = jo.getCpword();

		System.out.println(uname + " " + pword + " " + cword);
		hp = rp.register(uname, pword, cword);
		String htitle = hp.validateHomePageTitle();
		System.out.println(htitle);
		Assert.assertEquals(htitle, prop.getProperty("rtitle"));
		Thread.sleep(1000);
		

	}

	@DataProvider(name = "Signin details")
	public Iterator<RegisterPojo> registerinput() throws IOException {

		List<RegisterPojo> jo = new ArrayList<RegisterPojo>();
		for (int i = 1; i <= 3; i++) {

			RegisterPojo rp = new RegisterPojo();
			for (int j = 0; j <= 2; j++) {
				rp.setUname(ExcelUtil.getCellData(sheetname, i, j, expath));
				rp.setPword(ExcelUtil.getCellData(sheetname, i, j + 1, expath));
				rp.setCpword(ExcelUtil.getCellData(sheetname, i, j + 2, expath));

				jo.add(rp);
				break;

			}
		}
		System.out.println(jo.toString());
		return jo.iterator();
	}

	@AfterMethod
	public void endoftest() {
		System.out.println("********************************************************");
	}

}
