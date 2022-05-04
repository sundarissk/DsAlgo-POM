package com.DsAlog.Qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.DsAlgo.Qa.Base.Baseclass;

import io.qameta.allure.Attachment;

public class element_utility extends Baseclass {
	// public static long EXPLICITWAIT = 30;

	public static Workbook book;
	public static Sheet sheet;

	public static FileInputStream fi;
	public FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet1;
	public static XSSFRow row;
	public static XSSFCell cell;
	public CellStyle style;
	// static String path = null;

	public static void welehighlight(WebElement ele) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", ele);

	}

	public static void explicit_wait(WebElement element, int value) {
		new WebDriverWait(driver, Duration.ofSeconds(value)).until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void Element_Text(WebElement element, long timeout, String value) {
		WebElement E1 = new WebDriverWait(driver, Duration.ofMinutes(timeout))
				.until(ExpectedConditions.elementToBeClickable(element));
		E1.sendKeys(value);
	}

	public static void Element_Click(WebElement element, long timeout) {
		WebElement E1 = new WebDriverWait(driver, Duration.ofMinutes(timeout))
				.until(ExpectedConditions.elementToBeClickable(element));
		E1.click();
	}

	public static String gettextvalue(WebElement element) {

		return element.getText();

	}

	public static String gettitile() {

		return driver.getTitle();

	}

	public static Object[][] ExcelgetTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\Users\\skuma\\eclipse-workspace\\EBanking_POM\\src\\main\\java\\com\\EBanking\\Qa\\TestData\\Ebanking_testdata.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			System.out.println(i + "-->Row value passed to test");
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);

			}
		}
		return data;
	}

	public static String simple_alert(WebElement element) {

		// Click the link to activate the alert
		element.click();

		// Wait for the alert to be displayed and store it in a variable
		Alert alert = driver.switchTo().alert();

		// Store the alert text in a variable
		String text = alert.getText();

		System.out.println(text);
		// Press the OK button
		alert.accept();
		return text;
	}

	public static void takesshot(String filename) throws IOException {

		// 1.take screenshot and store it as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 2. Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		String despath = System.getProperty("user.dir") + "\\reports\\" + filename + ".png";
		// 3. Location to save screenshot
		File tar = new File(despath + " " + timestamp + ".jpeg");
		// 4. now copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(src, tar);

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

	/*
	 * public static String getCellData(String sheetName, int rownum, int
	 * colnum,String epath) throws IOException { fi = new FileInputStream(epath);
	 * workbook = new XSSFWorkbook(fi); sheet = workbook.getSheet(sheetName); row =
	 * sheet.getRow(rownum); cell = row.getCell(colnum);
	 * 
	 * DataFormatter formatter = new DataFormatter(); String data; try { data =
	 * formatter.formatCellValue(cell); // Returns the formatted value of a cell as
	 * a String regardless of // the cell type. } catch (Exception e) { data = ""; }
	 * workbook.close(); fi.close(); return data; }
	 */

}
