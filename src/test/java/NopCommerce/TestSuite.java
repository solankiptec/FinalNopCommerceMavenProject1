package NopCommerce;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Welcome on 29/07/2017.
 */

public class TestSuite extends BaseTest {

   HomePage homePage = new HomePage();
   ComputersPage computersPage = new ComputersPage();
   RegistrationPage registrationPage = new RegistrationPage();
   CellPhones cellPhones = new CellPhones();
   CartPage cartPage = new CartPage();
   OnePageCheckoutPage onePageCheckoutPage = new OnePageCheckoutPage();


    @Test(priority = 1)
    public void toVerifyUserShouldBeAlbeToRegister() {

        //clicking "Register"
        homePage.navigateToRegister();

        //Doing registration
        registrationPage.registration();

        //Asserting "Your registration completed"
        String actual = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actual, "Your registration completed", "Your registration is not completed successfully");
    }

    @Test(priority = 2)
    public void toVerifyUserShouldBeAbleToSendEmailToMyFriendIfRegistered() {

        //clicking "Register"
        homePage.navigateToRegister();

        //Doing registration
        registrationPage.registration();

        //click on computer/desktop/build you own/email a friend
        computersPage.clickComputer();

        //Asserting "Your registration completed"
        String actual = driver.findElement(By.xpath("//div[@class=\"page-body\"]/div[2]")).getText();
        Assert.assertEquals(actual, "Your message has been sent.", "Message is not sent. Please check");
    }

    @Test(priority = 3)
    public void toVerifyUserShouldNotSendEmailToMyFriendWithoutRegisteration() {

        //click on computer/desktop/build you own/email a friend
        computersPage.clickComputer();

        //Asserting "Only registered customers can use email a friend"
        String actual = driver.findElement(By.xpath("//div[@class=\"page-body\"]/form/div/div/ul/li")).getText();
        Assert.assertEquals(actual, "Only registered customers can use email a friend feature", "The condition that only registered customers can use 'email a friend feature' is not working properly");
    }

    @Test(priority = 4)
    public void toVerifyIfUserAddsProductIntoCartSameProductsAreAddedAndUserCanDoCheckoutSuccessfully(){

        //clicking "Register"
        homePage.navigateToRegister();

        //Doing registration
        registrationPage.registration();

        //mouse over on Electronics and click Cell Phone
        homePage.hoverOnElectronicsAndClickCellPhones();

        //selecting HTC One M8 and Nokia Lumia 1020 and adding into cart and then click on Shopping cart
        cellPhones.selectingProductsAndAddingToCartAndGettingText();

        //Verify products in shopping cart are same as selected then select country then click agree button then click checkout
        cartPage.toVerifySelectedProductsAreInShopppingCardThenClickCheckout();

        //filling out billing address on Checkout page
        onePageCheckoutPage.fillOutBillingAddressOnCheckout();

        //Asserting "Your order has been successfully processed!"
        String actual = driver.findElement(By.xpath("//div[@class=\"section order-completed\"]/div/strong")).getText();
        Assert.assertEquals(actual, "Your order has been successfully processed!", "Order is not placed successfully. Please check.");

    }
}


