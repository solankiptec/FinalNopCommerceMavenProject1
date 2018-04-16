package NopCommerce;

import PageObjects.CellPhones;
import PageObjects.ComputersPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Welcome on 29/07/2017.
 */
public class BaseTest extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();

    LoadProp loadProp = new LoadProp();


   @BeforeMethod
       public void openBrowser( ){

       //open browser
       browserSelector.openBrowser(loadProp.getProperty("browser"));

       //navigate to homepage
       driver.get(loadProp.getProperty("url"));

    }



  @AfterMethod
    public static void tearDown(ITestResult result)
    {
        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                // Create reference of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));

                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        // close application
        driver.quit();
    }
  }



