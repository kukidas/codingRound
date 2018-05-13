package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

import pageobject.BaseTest;
import pageobject.SignInBookingPage;

public class SignInTest extends BaseTest {

    WebDriver driver;
    SignInBookingPage signInBookingPage;
    
    public SignInTest(){
    	super();
    	this.driver = getDriver();
    	signInBookingPage = new SignInBookingPage(driver);
    }
   
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        
        signInBookingPage.clickOnYourTrips();
        signInBookingPage.clickOnSignInButtonInYourTripsDropdown();
        waitFor(2000);
        
        driver.switchTo().frame("modal_window");
        signInBookingPage.clickOnSignInButtonInTheIFrame();
        Assert.assertTrue(signInBookingPage.getErrorMessage().contains("There were errors in your submission"));
        driver.quit();
    }
}
