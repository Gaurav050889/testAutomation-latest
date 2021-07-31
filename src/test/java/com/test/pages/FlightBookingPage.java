package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingPage {
	
	WebDriver driver;
	public FlightBookingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String expHeadingNote="Your flight from TLV to SFO has been reserved.";

	
	By inputName= By.id("inputName");
	By address =By.id("address");
	By city = By.id("city");
	By state = By.id("state");
	By zipCode =By.id("zipCode");
	By cardType=By.id("cardType");
	By creditCardNumber=By.id("creditCardNumber");
	By creditCardMonth=By.id("creditCardMonth");
	By creditCardYear=By.id("creditCardYear");
	By nameOnCard=By.id("nameOnCard");
	By submit=By.xpath("//input[@type='submit']");
	By welCometextNote=By.tagName("h2");
	By bookingStatus=By.tagName("h1");
	
	public void uname(String name) {
		driver.findElement(inputName).sendKeys(name);
	}
	
	public void setAddress(String uaddress) {
		driver.findElement(address).sendKeys(uaddress);
	}
	
	public void setCity(String cityName) {
		driver.findElement(city).sendKeys(cityName);
	}
	
	public void setState(String stateName) {
		driver.findElement(state).sendKeys(stateName);
	}
	
	public void setZipCode(String zipCodeNumber) {
		driver.findElement(zipCode).sendKeys(zipCodeNumber);
	}
	
	public void setCardType(String cardTypeName) {
		Select select = new Select(driver.findElement(cardType));
		select.selectByVisibleText(cardTypeName);		
	}
	
	public void setCreditCardNumber(String ccNumber) {
		driver.findElement(creditCardNumber).sendKeys(ccNumber);
	}
	
	public void setCreditcardMonth(String creditCardMonthNumber) {
		driver.findElement(creditCardMonth).sendKeys(creditCardMonthNumber);
	}
	
	public void setCreditCardyear(String ccYear) {
		driver.findElement(creditCardYear).sendKeys(ccYear);
	}
	
	public void setName(String ccUserName) {
		driver.findElement(nameOnCard).sendKeys(ccUserName);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();;
	}
	
	public String getExpHeadingNot() {
		return driver.findElement(welCometextNote).getText();
	}
	
	public boolean getBookingStatus() {
		return driver.findElement(bookingStatus).isDisplayed();
	}

}
