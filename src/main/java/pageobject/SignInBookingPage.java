package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInBookingPage {
	WebDriver driver;
	
	@FindBy(linkText = "Your trips")
	private WebElement yourTripsDropDown;
	
	@FindBy(id = "SignIn")
	private WebElement signInHomePage;
	
	@FindBy(id = "signInButton")
	private WebElement signInIFrame;
	
	@FindBy(id ="errors1")
	private WebElement errorsMessage;
	
	public SignInBookingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//this will click on the Your trips drop down in the main window
	public void clickOnYourTrips(){
		yourTripsDropDown.click();
	}
	
	//this will click on the sign in button which displays on the Your trips dropdwon
	public void clickOnSignInButtonInYourTripsDropdown(){
		signInHomePage.click();
	}
	
	//this will click on the sign in button which displays on the Sign in to cleartrip iFrame
	public void clickOnSignInButtonInTheIFrame(){
		signInIFrame.click();
	}
	
	//this will retrieve the error message which displays for wrong sign in attempt 
	public String getErrorMessage(){
		return errorsMessage.getText();
	}

}
