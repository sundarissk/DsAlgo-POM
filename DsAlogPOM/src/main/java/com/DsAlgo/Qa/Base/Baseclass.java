package com.DsAlgo.Qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static Properties prop;

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	// username and password valid for only 20 days of creation , it created on
	// 3/29/2022

	public Baseclass() {

		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"C:\\Users\\skuma\\eclipse-workspace\\DsAlogPOM\\src\\main\\java\\com\\DsAlgo\\Qa\\Config\\config.properties");
			prop.load(ip);

			// System.out.println(prop.getProperty("browser"));
			// browsername = prop.getProperty("browser");
			// url = prop.getProperty("url");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

	public void initialization(String browsername) {
		// String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("No Browser value is given");

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get(prop.getProperty("url"));

	}

	public synchronized static WebDriver getDriver() {
		return tdriver.get();
	}

	public String getScreenshot(String filename) throws IOException {

		// 1.take screenshot and store it as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 2. Open the current date and time
		// String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new
		// Date());

		// 2. Store path in varibale to use it in report
		String despath = System.getProperty("user.dir") + "\\reports\\" + filename + ".png";
		// 3. Location to save screenshot
		File tar = new File(despath);
		// 4. now copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(src, tar);
		return despath;

	}

	public String getbroswername() {
		Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = browserCap.getBrowserName();
		return browserName;

	}

}
