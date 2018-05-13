package test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sun.javafx.PlatformUtil;
import pageobject.FlightBookingPage;

public class FlightBookingTest {
	
	WebDriver driver;
	FlightBookingPage flightBookingPage;

	@BeforeTest
    public void initialize(){
    	setDriverPath();
    	driver  = new ChromeDriver();   
    	flightBookingPage = new FlightBookingPage(driver);
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        flightBookingPage.clickOnOneWayButton();
        flightBookingPage.clearOriginPlaceTextBox();
        flightBookingPage.typeOriginPlace("Bangalore");
        //wait for the auto complete options to appear for the origin
        waitFor(2000);
        
        flightBookingPage.selectOriginPlace(0);
        flightBookingPage.clearDestinationPlaceTextBox();
        flightBookingPage.typeDestinationPlace("Delhi"); 
        //wait for the auto complete options to appear for the destination
        waitFor(2000);
        
        //select the first item from the destination auto complete list
        flightBookingPage.selectDestinationPlace(0);
        flightBookingPage.selectDate();
        
        //all fields filled in. Now click on search
        flightBookingPage.clickOnSearchButton();
        waitFor(5000);
        
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
        driver.quit();
    }


    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
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
