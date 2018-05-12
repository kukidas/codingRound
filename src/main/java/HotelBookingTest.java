import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class HotelBookingTest {

	WebDriver driver;   
    
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
       
    @BeforeClass
    public void initialize(){
    	setDriverPath();
    	driver  = new ChromeDriver();   
    	//initializing page objects via pagefactory
    	PageFactory.initElements(driver, this); 
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        
    	driver.get("https://www.cleartrip.com/");
    	hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");
        
        waitFor(1000);
        
        //Selecting the first option from the auto suggest drop down
        List<WebElement> list= driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        list.get(1).click();
        
        //Selecting the check in date from DatePicker
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[1]/a")).click();
        waitFor(2000);
        
       //Selecting the check out date from DatePicker
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[3]/a")).click();
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        
        waitFor(2000);
        searchButton.click();

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
