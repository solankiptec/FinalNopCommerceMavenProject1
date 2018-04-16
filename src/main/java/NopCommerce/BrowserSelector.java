package NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends BasePage {



    //open Firefox or Chrome or Internet Explorer browser
    public void openBrowser(String browser){
/*
        if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaghelab\\IdeaProjects\\FinalMavenProject1\\src\\test\\Resources\\BrowserDriver\\chromedriver-2.22.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\vaghelab\\IdeaProjects\\FinalMavenProject1\\src\\test\\Resources\\BrowserDriver\\IEDriverServer-2.53.exe");
            driver = new InternetExplorerDriver();
        }
        else
        {
            System.out.println("Invalid browser or wrong browser typed");
        }
  */

        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver-2.30.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer-3.4.exe");
            driver = new InternetExplorerDriver();

        } else {
            System.out.println("Invalid browser or wrong browser typed");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

//System.setProperty("webdriver.gecko.driver", "C:\\Soft\\geckodriver.exe");