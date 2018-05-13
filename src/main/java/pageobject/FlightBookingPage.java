package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPage {
	WebDriver driver;
	
	@FindBy(id = "OneWay")
	private WebElement oneWay;
	
	@FindBy(id = "FromTag")
	private WebElement originPlace;
	
	@FindBy(id = "ToTag")
	private WebElement destinationPlace;
	
	@FindBy(id = "ui-id-1")
	private WebElement originOptions;
	
	@FindBy(id = "ui-id-2")
	private WebElement destinationOptions;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	private WebElement datePickerValue;
	
	@FindBy(id = "SearchBtn")
	private WebElement searhButton;
	
	@FindBy(className = "searchSummary")
	private WebElement searchSummary;
	
	
	public FlightBookingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//This will click on the One way radio button
	public void clickOnOneWayButton(){
		oneWay.click();
	}
	
	//This will clear the From text box where we enter the origin place
	public void clearOriginPlaceTextBox(){
		originPlace.clear();
	}
	
	//This will type the original place from where the traveler will travel
	public void typeOriginPlace(String place){
		originPlace.sendKeys(place);
	}
	
	//Select the place of Origin from the dropdown
	public void selectOriginPlace(int index){
		List<WebElement> list= originOptions.findElements(By.tagName("li"));
		list.get(index).click();
	}
	
	//This will clear the From text box where we enter the origin place
		public void clearDestinationPlaceTextBox(){
			destinationPlace.clear();
	}
		
	//This will type the original place from where the traveler will travel
	public void typeDestinationPlace(String place){
		destinationPlace.sendKeys(place);
	}
	
	//Select the place of Destination from the dropdown 
	public void selectDestinationPlace(int index){
	List<WebElement> list = destinationOptions.findElements(By.tagName("li"));
	list.get(index).click();
	}
	
	//Select Date from the date picker
	public void selectDate(){
		datePickerValue.click();
	}
	
	//click on the search button
	public void clickOnSearchButton(){
		searhButton.click();
	}
}
