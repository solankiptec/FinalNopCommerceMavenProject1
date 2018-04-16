package PageObjects;

import NopCommerce.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Welcome on 29/07/2017.
 */
public class RegistrationPage extends Utils {

    private By _genderMale = By.id("gender-male");
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _dateOfBirthDay = By.name("DateOfBirthDay");
    private By _dateOfBirthMonth = By.name("DateOfBirthMonth");
    private By _dateOfBirthYear = By.name("DateOfBirthYear");
    private By _email = By.id("Email");
    private By _company = By.id("Company");
    private By _newsletter = By.id("Newsletter");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.xpath("//input[contains(@id,\"register-button\") and contains(@name,\"register-button\")]");
    private By _continueButton = By.name("register-continue");


    public void registration() {
        //Select Gender male
        myClick(_genderMale);

        //Enter firstname
        myEnterText(_firstName, "Bhagirath");

        //Enter last name
        myEnterText(_lastName, "Vaghela");

        //Select Birth Day
        mySelectByIndex(_dateOfBirthDay, 11);

        //Select Birth Month
        Select month = mySelectByVisibleText(_dateOfBirthMonth, "April");

        //Select Birth Year
        mySelectByValue(_dateOfBirthYear, "1980");

        //Enter email
        String mydate = randomNumber(_email, "bhagirat");

        //Enter company details
        myEnterText(_company, "Sunflower Testing");

        //scroll page down (i.e. y=250)
        scrollPage(0,250);

        //untick newsletter
        myClick(_newsletter);

        //Enter password
        myEnterText(_password, "Testing123");

        //Enter confirm password
        myEnterText(_confirmPassword, "Testing123");

        //click on Register
        myClick(_registerButton);

        //click on Continue Button
        myClick(_continueButton);
    }
}
