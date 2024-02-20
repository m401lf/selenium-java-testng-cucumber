package testCases.Demos.DemoPractice.Log4J.ClassExamples_2.ClassExamples.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	WebDriver ldriver;
	
	RegistrationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="REGISTER")
	@CacheLookup
	WebElement RegLink;
	
	@FindBy(name="firstName")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(name = "lastName")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(name = "phone")
	@CacheLookup
	WebElement phone;
	
	@FindBy(name = "userName")
	@CacheLookup
	WebElement email;
	
	@FindBy(name = "address1")
	@CacheLookup
	WebElement address1;
	
	@FindBy(name = "address2")
	@CacheLookup
	WebElement address2;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement state;
	
	@FindBy(name = "postalCode")
	@CacheLookup
	WebElement postalCode;
	
	@FindBy(name = "country")
	@CacheLookup
	WebElement country;
	
	@FindBy(name = "email")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "confirmPassword")
	@CacheLookup
	WebElement confirmpassword;
	
	@FindBy(name = "register")
	@CacheLookup
	WebElement registerBtn;
	
	public void clickRegLink() {
		RegLink.click();
	}
	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		LastName.sendKeys(lname);

	}
	
	public void setPhone(String ph) {
		phone.sendKeys(ph);
	}

	public void setemail(String mail) {
		email.sendKeys(mail);
	}

	public void setAddress1(String addr1) {
		address1.sendKeys(addr1);
	}

	public void setAddress2(String addr2) {
		address2.sendKeys(addr2);
	}

	public void setCity(String ci) {
		city.sendKeys(ci);
	}

	public void setState(String st) {
		state.sendKeys(st);
	}
	
	public void setPostalCode(String pcode) {
		postalCode.sendKeys(pcode);
	}

	public void setCountry(String cn) {

		Select drop = new Select(country);
		drop.selectByVisibleText(cn);
	}
	
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String passwrd) {
		password.sendKeys(passwrd);
	}

	public void setConfirmedPassword(String passwrd) {
		confirmpassword.sendKeys(passwrd);
	}
	
	public void clickRegBtn() {
		registerBtn.click();
	}
	
}
