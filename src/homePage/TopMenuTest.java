package homePage;

import Laptopsandnotebooks.LaptopAndNotebooksTest;
import Testing.BaseTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import javax.swing.*;
import java.util.List;

public class TopMenuTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        setUp(baseUrl);
    }


    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();

    }


    @Test
    public void NavigateToDesktopsPage() {
        WebElement desktop = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        desktop.click();
        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div[1]/a");
        String ActualText = driver.findElement(By.tagName("h2")).getText();
        String expectedText = "Desktops";
        Assert.assertEquals(expectedText,ActualText);



    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        WebElement LaptopsAndNotebooks = driver.findElement(By.className("dropdown-toggle"));
        LaptopsAndNotebooks.click();
        selectMenu("//ul[@class='nav navbar-nav']/li[2]/a");
        String ActualText = driver.findElement(By.xpath("//li[@class='dropdown open']/a")).getText();
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(expectedText,ActualText);

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        WebElement Components  = driver.findElement(By.className("dropdown-toggle"));
        Components.click();
        selectMenu("//ul[@class='nav navbar-nav']/li[3]/a");
        String ActualText = driver.findElement(By.xpath("//li[@class='dropdown open']/a")).getText();
        String expectedText = "Components";
        Assert.assertEquals(expectedText,ActualText);


    }

@After
    public void endTest(){
        closeBrowser();
}
}


