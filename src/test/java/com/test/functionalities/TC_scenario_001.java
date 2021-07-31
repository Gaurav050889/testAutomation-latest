package com.test.functionalities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.pages.ChooseFlightpage;
import com.test.pages.FlightBookingPage;
import com.test.pages.WelcomePage;

public class TC_scenario_001 extends Base {

	@Test(dataProvider = "excel-data-TC01")
	public void verifyFlightWebsite(String depCity, String destCity) throws InterruptedException {
		driver.get(baseUrl);
		test.log(Status.INFO, "The flight booking website is launched successfully");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WelcomePage wlcm = new WelcomePage(driver);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Assert.assertEquals(wlcm.welComeNoteText(), wlcm.expHeartext);
		test.log(Status.PASS, "The test is passed with text proper text displaying");
		wlcm.selectDepCity(depCity);
		wlcm.selectDestCity(destCity);
		wlcm.clickSubmit();
	}

	@Test(dependsOnMethods = { "verifyFlightWebsite" }, dataProvider = "excel-data-TC02")
	public void verifychooseFlight(String flightName) {
		ChooseFlightpage cflt = new ChooseFlightpage(driver);
		test.log(Status.INFO, "The flight choosing page is launched successfully");
		Assert.assertEquals(cflt.isFirstLineDisaplyed(), true);
		test.log(Status.PASS, "The first line is displaying correctly");
		Assert.assertEquals(cflt.isButtonEnabled(), true);
		test.log(Status.PASS, "The button is displaying correctly");
		cflt.chooseFlight(flightName);
	}

	@Test(dependsOnMethods = { "verifychooseFlight" }, dataProvider = "excel-data-TC03")
	public void verifyflightBooking(String userName, String address, String city, String state, String zipCode,
			String creditcardtype, String ccnum, String ccmonth, String ccyear, String fullname)
			throws InterruptedException {
		FlightBookingPage flbg = new FlightBookingPage(driver);
		Assert.assertEquals(flbg.getExpHeadingNot(), flbg.expHeadingNote);
		test.log(Status.PASS, "The expected heading note is displaying correctly");
		flbg.uname(userName);
		flbg.setAddress(address);
		flbg.setCity(city);
		flbg.setState(state);
		flbg.setZipCode(zipCode);
		flbg.setCardType(creditcardtype);
		flbg.setCreditCardNumber(ccnum);
		flbg.setCreditcardMonth(ccmonth);
		flbg.setCreditCardyear(ccyear);
		flbg.setName(fullname);
		flbg.clickSubmit();
		Thread.sleep(4000);
		Assert.assertEquals(flbg.getBookingStatus(), true);
		test.log(Status.PASS, "The booking status message is showing correctly");
	}

	@DataProvider(name = "excel-data-TC01")
	public Object[][] getDataTC_01() throws IOException {
		Object[][] obj = excel.getExcelData(".\\src\\main\\resources\\Excel\\ExcelSheet.xlsx", "verifyFlightWebsite");
		return obj;
	}

	@DataProvider(name = "excel-data-TC02")
	public Object[][] getDataTC_02() throws IOException {
		Object[][] obj = excel.getExcelData(".\\src\\main\\resources\\Excel\\ExcelSheet.xlsx", "verifychooseFlight");
		return obj;
	}

	@DataProvider(name = "excel-data-TC03")
	public Object[][] getDataTC_03() throws IOException {
		Object[][] obj = excel.getExcelData(".\\src\\main\\resources\\Excel\\ExcelSheet.xlsx", "verifyflightBooking");
		return obj;
	}

	@BeforeMethod
	public static void startTest() {
		report = new ExtentSparkReporter(".\\TestReports\\test.html");
		report.config().setTheme(Theme.STANDARD);
		report.config().setDocumentTitle("Test Case Report");
		test = extent.createTest("The test case for flight website").assignCategory("PositiveScenario");
		extent.attachReporter(report);
	}

	@AfterMethod
	public static void endTest() {
		extent.flush();
	}
}
