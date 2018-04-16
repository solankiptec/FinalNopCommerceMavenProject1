package PageObjects;

import NopCommerce.BasePage;
import NopCommerce.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

/**
 * Created by Welcome on 29/07/2017.
 */
public class HomePage extends Utils {

    SoftAssert softAssertObj = new SoftAssert();

    private By _pageTitle = By.className("page-title");
    private By _Register = By.linkText("Register");
    private By _Electronics = By.linkText("Electronics");
    private By _CellPhones = By.linkText("Cell phones");


    public void navigateToRegister(){

        //click on register
        myClick(_Register);

        String actualString = getText(_pageTitle);
        softAssertObj.assertEquals(actualString, "Register", "Register page is not loaded");
        softAssertObj.assertAll();

    }

    public void hoverOnElectronicsAndClickCellPhones(){
       hoverEffect(_Electronics, _CellPhones);
    }
}
