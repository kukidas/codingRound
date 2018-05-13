package test;
import com.sun.javafx.PlatformUtil;

import pageobject.BaseTest;
import pageobject.HotelBookingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class HotelBookingTest extends BaseTest{

	WebDriver driver;   
	HotelBookingPage hotelbookingpage;
	public HotelBookingTest(){
		super();
		this.driver = getDriver();
		hotelbookingpage = new HotelBookingPage(driver); 
	}
	
    @Test
    public void shouldBeAbleToSearchForHotels() {
        
    	driver.get("https://www.cleartrip.com/");
    	hotelbookingpage.clickOnHotelLink();
    	hotelbookingpage.typeLocation("Indiranagar, Bangalore");
    	waitFor(1000);
    	hotelbookingpage.selectLocationFromDropDown(1);
    	waitFor(2000);
    	hotelbookingpage.selectCheckInDate();
    	waitFor(1000);
    	hotelbookingpage.selectCheckOutDate();
    	hotelbookingpage.selectTravellerSelection("1 room, 2 adults");
    	hotelbookingpage.clickSearchButton();
    	
    	driver.quit();
    } 
}
