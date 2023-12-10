package myaccounts;

import Testing.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyAccountsTest extends BaseTest {


    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        setUp(baseUrl);
    }


    public void selectMyAccount(String option) {
        WebElement menuLink = driver.findElement(By.xpath(option));
        menuLink.click();
    }

    public void selectMyAccountOptions1(String option) {
        WebElement menuLink = driver.findElement(By.linkText(option));
        menuLink.click();

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();
        selectMyAccount("//ul[@class='dropdown-menu dropdown-menu-right']/li[1]");
        String ActualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText = "Register Account";
        Assert.assertEquals(expectedText, ActualText);
    }


    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();
        selectMyAccount("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]");
        String ActualText = driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/h2")).getText();
        String expectedText = "Returning Customer";
        Assert.assertEquals(expectedText, ActualText);
    }


    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        WebElement myAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myAccount.click();
        selectMyAccount("//ul[@class='dropdown-menu dropdown-menu-right']/li[1]");

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Kelly");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Brown");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("kellybrown@gmail.com");

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("4155090949");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123abcD");

        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("123abcD");

        WebElement yesRadioButton = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/fieldset[3]/div[1]/div[1]/label/input[1]"));
        yesRadioButton.click();

        WebElement privacyPolicyCheckBox = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[1]"));
        privacyPolicyCheckBox.click();

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[2]"));
        continueButton.click();

        Thread.sleep(1000);

        String actualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText = "Your Account Has Been Created!";
        Assert.assertEquals(actualText, expectedText);

        WebElement continueButton1 = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/a"));
        continueButton1.click();

        WebElement myLoggedInAccount = driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]"));
        myLoggedInAccount.click();

        selectMyAccountOptions1("Logout");

        Thread.sleep(1000);

        String actualText1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedText1 = "Account Logout";
        Assert.assertEquals(actualText1, expectedText1);

        WebElement continueButton2 = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/a"));
        continueButton2.click();

    }

    @After

    public void endTest() {

        closeBrowser();
    }


}









