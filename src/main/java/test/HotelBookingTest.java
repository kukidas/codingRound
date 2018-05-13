package test;
import com.sun.javafx.PlatformUtil;

import pageobject.HotelBookingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class HotelBookingTest {

	WebDriver driver;   
	HotelBookingPage hotelbookingpage;
	      
    @BeforeClass
    public void initialize(){
    	setDriverPath();
    	driver  = new ChromeDriver();      	 
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
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
   private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_mac");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_win.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
