package PageObjects;

import NopCommerce.Utils;
import org.openqa.selenium.*;

public class CellPhones extends Utils {

    private By _HTCOneM8 = By.linkText("HTC One M8 Android L 5.0 Lollipop");
    private By _AddToCartHTCOneM8 = By.xpath("//div[@class=\"item-grid\"]/div/div/div[2]/div[3]/div[2]/input");
    private By _Lumia1020 = By.linkText("Nokia Lumia 1020");
    private By _AddToCartLumia1020 = By.xpath("//div[@class=\"item-grid\"]/div[3]/div/div[2]/div[3]/div[2]/input");
    private By _closeShoppingCartNotificationBar = By.xpath("//div[@id=\"bar-notification\"]/span");
    private By _shoppingCart = By.linkText("Shopping cart");
    String HTCOneM8, Lumia1020;


    public void selectingProductsAndAddingToCartAndGettingText(){

        //Get text of HTCOneM8
        String HTCOneM8 = getText(_HTCOneM8);
        System.out.println(HTCOneM8);

        //scroll page down
        scrollPage(0, 350);

        //click on Add to Cart
        myClick(_AddToCartHTCOneM8);

        //click on close button of notification bar
       // myClick(_closeShoppingCartNotificationBar);

        //Get text of HTCOneM8
        String Lumia1020 =  getText(_Lumia1020);
        System.out.println(Lumia1020);

        //scroll page down
        scrollPage(0,250);

        //wait until element is ready //click on Add to Cart
        waitAndClickCommand(_AddToCartLumia1020);

        //click on close button of notification bar
        myClick(_closeShoppingCartNotificationBar);

        //scroll page up
        scrollPage(0, -250);

        //click on shopping cart on top right corner
        myClick(_shoppingCart);


    }
}
