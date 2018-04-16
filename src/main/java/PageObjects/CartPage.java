package PageObjects;

import NopCommerce.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import static NopCommerce.Utils.getText;

public class CartPage extends Utils {

    SoftAssert softAssertObj = new SoftAssert();

    CellPhones cellPhones = new CellPhones();

    private By _HTCOneM8inCheckout = By.xpath("//tbody/tr/td[4]/a");
    private By _Lumia1020inCheckout = By.xpath("//tbody/tr[2]/td[4]/a");
    private By _countryID = By.id("CountryId");
    private By _termsOfService = By.id("termsofservice");
    private By _checkOut  = By.id("checkout");
    private By _pageTitle = By.className("page-title");

public void toVerifySelectedProductsAreInShopppingCardThenClickCheckout(){

    //get text of products appeared in shopping cart
    String HTCOneM8inCheckout = getText(_HTCOneM8inCheckout);
    String Lumia1020inCheckout = getText(_Lumia1020inCheckout);

    System.out.println(HTCOneM8inCheckout+" "+Lumia1020inCheckout);

    //Soft assert of shopping cart's products against products added in cart
    softAssertObj.assertEquals(HTCOneM8inCheckout,"HTC One M8 Android L 5.0 Lollipop", "Product in shopping cart is different then added at the time of buying");
    softAssertObj.assertEquals(Lumia1020inCheckout,"Nokia Lumia 1020", "Product in shopping cart is different then added at the time of buying");

    //Select country United Kingdom
    mySelectByVisibleText(_countryID, "United Kingdom");

    //click on "I agree" check box
    myClick(_termsOfService);

    //click on Checkout
    myClick(_checkOut);

//    Alert alt = driver.switchTo().alert();
//    alt.accept();

    isAlertPresent();

    if (isAlertPresent()) {
        System.out.println("Alert is present");
        driver.switchTo().alert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    String actualString = getText(_pageTitle);
    softAssertObj.assertEquals(actualString, "Checkout", "Checkout page is not loaded");

    softAssertObj.assertAll();
}
}
