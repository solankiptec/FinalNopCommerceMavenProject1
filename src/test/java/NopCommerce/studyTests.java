package NopCommerce;

import PageObjects.ComputersPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Welcome on 30/07/2017.
 */
public class studyTests extends BaseTest {

    @Test
    public void toVerifySearchOptionIsWorkingOkay(){

        driver.findElement(By.id("small-searchterms")).sendKeys("HTC");
        driver.findElement(By.xpath("//input[contains (@value, \"Search\") and contains (@type, \"submit\")]")).click();

        //By.xpath("//input[contains (@class, \"button-1 send-email-a-friend-button\")and contains(@name, \"send-email\")]");

        List<WebElement> _products;
        _products = driver.findElements(By.xpath("//div[@class=\"item-grid\"]/div/div/div[2]/h2/a"));
        System.out.println(_products.size());

        String[] linkTexts = new String[_products.size()];

        int i = 0;

        //extract the link texts of each link element
        for (WebElement e : _products) {
            linkTexts[i] = e.getText();
            i++;
        }

        for (String t : linkTexts) {
            driver.findElement(By.linkText(t)).click();
            String title = driver.getTitle();

            if (title.contains(t)) {
                System.out.println(t+" is HTC product");
        }else{
                System.out.println(t+" is not a HTC product");}
        }

    }
}
