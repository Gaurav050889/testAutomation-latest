package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseFlightpage {
	
	WebDriver driver;
	public ChooseFlightpage(WebDriver driver) {
		this.driver=driver;
	}
	
	By chooseButton=By.xpath("//input[@value='Choose This Flight']");
	By headingLine=By.xpath("//div[2]/h3");
	
	public void chooseFlight(String airLineName) {
		for(int i=1; i<=5; i++) {
			String svalue=null;
			svalue=driver.findElement(By.xpath("//div[2]/table/tbody/tr["+i+"]/td[3]")).getText();
			if(svalue.equalsIgnoreCase(airLineName)) {
				System.out.println("The xpath used is "+"//div[2]/table/tbody/tr["+i+"]/td[3]");
				driver.findElement(By.xpath("//div[2]/table/tbody/tr["+i+"]/td[1]")).click();
				break;
			}
		}
	}
	
	public boolean isButtonEnabled() {
		boolean enable = false;
		List<WebElement> list = driver.findElements(chooseButton);
		for (WebElement wb : list) {
		enable=wb.isEnabled();
		}		
		return enable;
	}
	
	public boolean isFirstLineDisaplyed(){
		return driver.findElement(headingLine).isDisplayed();		
	}

}
