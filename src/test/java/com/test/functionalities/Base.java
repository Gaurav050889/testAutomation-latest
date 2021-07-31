package com.test.functionalities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.util.ReadExcelData;
import com.test.util.SetProperties;

public class Base {
	
	SetProperties get=new SetProperties();
	public String baseUrl=get.getApplicationUrl();
	public String username=get.getUsername();
	public static WebDriver driver;
	ReadExcelData excel=new ReadExcelData();
	public static ExtentSparkReporter report;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
