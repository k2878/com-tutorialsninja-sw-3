package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {
    public static WebDriver driver;
    String Url = "http://tutorialsninja.com/demo/index.php?";
    public void setUp(String baseurl){

        driver = new FirefoxDriver();

        driver.get(baseurl);
        driver.manage().window().maximize();

    }
    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();



    }
    public void closeBrowser(){driver.quit();}

}


