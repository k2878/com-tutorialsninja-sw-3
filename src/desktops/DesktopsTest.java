package desktops;

import Testing.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DesktopsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        setUp(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        WebElement desktopTab = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        desktopTab.click();

        WebElement ShowAllDesktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div[1]/a"));
        ShowAllDesktops.click();

        WebElement sortByPosition = driver.findElement(By.id("input-sort"));
        sortByPosition.click();
        Select select = new Select(sortByPosition);
        select.selectByIndex(2);


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {


        WebElement desktopTab = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        desktopTab.click();

        WebElement ShowAllDesktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div[1]/a"));
        ShowAllDesktops.click();

        WebElement sortByPosition = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sortByPosition.click();
        Select select = new Select(sortByPosition);
        select.selectByIndex(1);


        WebElement selectProduct = driver.findElement(By.xpath("//div[@id='content']/div[4]/div[3]/div/div[2]/div/h4/a"));
        selectProduct.click();

        Thread.sleep(2000);

        String actualText5 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        String expectedText5 = "HP LP3065";
        Assert.assertEquals(actualText5, expectedText5);


        WebElement deliveryDate = driver.findElement(By.id("input-option225"));
        deliveryDate.clear();
        deliveryDate.sendKeys("2024-11-30");


        WebElement quantityInput = driver.findElement(By.id("input-quantity"));
        quantityInput.clear(); // Clear any existing value
        quantityInput.sendKeys("1"); // Enter a new value

        Thread.sleep(2000);

        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();

        Thread.sleep(2000);

        String actualText1 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        System.out.println(actualText1);
        Assert.assertEquals(actualText1, expectedText1);

        Thread.sleep(1000);

        WebElement shoppingCart = driver.findElement(By.linkText("shopping cart"));
        shoppingCart.click();

        String actualText2 = driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[2]/a")).getText();
        String expectedText2 = "Shopping Cart";
        Assert.assertEquals(actualText2, expectedText2);

        String actualText3 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/A")).getText();
        String expectedText3 = "HP LP3065";
        Assert.assertEquals(actualText3, expectedText3);

        String actualText4 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/small[1]")).getText();
        String expectedText4 = "Delivery Date:2024-11-30";
        Assert.assertEquals(actualText4, expectedText4);

        String actualText7 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        String expectedText7 = "Product 21";
        Assert.assertEquals(actualText7, expectedText7);

        String actualText6 = driver.findElement(By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
        String expectedText6 = "$122.00";
        Assert.assertEquals(actualText6, expectedText6);

    }

    @After

    public void endTest() {

        closeBrowser();
    }

}










