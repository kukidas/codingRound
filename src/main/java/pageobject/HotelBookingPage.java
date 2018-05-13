package pageobject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage {
	
	WebDriver driver;	
	
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(id = "ui-id-1")
    private WebElement locationDropDown;
    
    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[3]/a")
    private WebElement checkInDate;
    
    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[3]/a")
    private WebElement checkOutDate;
    
    public HotelBookingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    // this will click on the hotel link in the main page
	public void clickOnHotelLink(){
		hotelLink.click();
	}
	
	//this will type the location in the location box
	public void typeLocation(String location){
		localityTextBox.sendKeys(location);
	}
	
	//Selecting the first option from the auto suggest drop down
	public void selectLocationFromDropDown(int index){
	List<WebElement> list= locationDropDown.findElements(By.tagName("li"));
	list.get(index).click();
	}
	
	//Selecting the check in date from DatePicker
	public void selectCheckInDate(){
		checkInDate.click();
	}
	
	//Selecting the check out date from DatePicker
	public void selectCheckOutDate(){
		checkOutDate.click();
	}
    
    //This will type the traveler information
     public void selectTravellerSelection(String travellerInformation){
    	new Select(travellerSelection).selectByVisibleText(travellerInformation);
    }
     
     //This will click on the search button
     public void clickSearchButton(){
    	 searchButton.click();
     }
    
	
	

}
