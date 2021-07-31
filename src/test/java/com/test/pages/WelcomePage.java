package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
	
	WebDriver driver;
	
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String expHeartext="Welcome to the Simple Travel Agency!";
	
	By depCity=By.xpath("//select[@name='fromPort']");
	By destCity=By.xpath("//select[@name='toPort']");
	By findFlights=By.xpath("//input[@type='submit']");
	By welcomeNote = By.tagName("h1");
	
	public void clickSubmit() {
		driver.findElement(findFlights).click();
	}
	
	public void selectDepCity(String startCity) {
		Select select = new Select(driver.findElement(depCity));
		select.selectByVisibleText(startCity);
	}
	
	public void selectDestCity(String landCity) {
		Select select = new Select(driver.findElement(destCity));
		select.selectByVisibleText(landCity);
	}
	
	public String welComeNoteText() {
	 return	driver.findElement(welcomeNote).getText();
	}

}
