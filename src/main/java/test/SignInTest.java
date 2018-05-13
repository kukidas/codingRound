package test;
import com.sun.javafx.PlatformUtil;

import pageobject.SignInBookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver;
    SignInBookingPage signInBookingPage;
    
    @BeforeTest
    public void initialize(){
    	setDriverPath();
    	driver  = new ChromeDriver(); 
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
