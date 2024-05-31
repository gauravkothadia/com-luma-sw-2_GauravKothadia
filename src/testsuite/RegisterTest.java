package testsuite;
/**
 *   3. Write down the following test into ‘RegisterTest’
 *  class
 *  1. verifyThatSignInPageDisplay
 *  * click on the ‘Create an Account’ link
 *  * Verify the text ‘CreateNewCustomer Account’
 *  2. userSholdRegisterAccountSuccessfully
 *  * click on the ‘Create an Account’ link
 *  * Enter First name
 *  * Enter Last name
 *  * Click on checkbox Sign Up for Newsletter
 *  * Enter Emai
 *  * Enter Password
 *  * Enter Confirm Password
 *  * Click on Create an Account button
 *  * Verify the text 'Thank you for
 *  registering with Main Website Store.’
 *  * Click on down aero neare Welcome
 *  * Click on Sign Out link
 *  * Verify the text ‘Youaresignedout’
 */

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.bouncycastle.util.Store;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;


public class RegisterTest extends BaseTest {
    @Before
    public void browserSetup() {
        openBrowser("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        // click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        // Verify the text ‘CreateNewCustomer Account’
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title-wrapper']//span[contains(text(),'New Customer Account')]")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        // click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        // Enter First name
        driver.findElement(By.id("firstname")).sendKeys("Gaurav");
        // Enter Last name
        driver.findElement(By.id("lastname")).sendKeys("Patel");
        // Click on checkbox Sign Up for Newsletter
        //----------not visible in the webpage, as it might be removed by website owner.--------
        // Enter Email
        driver.findElement(By.id("email_address")).sendKeys("gaurav12346@gmail.com");
        // Enter Password
        driver.findElement(By.name("password")).sendKeys("gaurav123@");
        // Enter Confirm Password
        driver.findElement(By.name("password_confirmation")).sendKeys("gaurav123@");
        // Click on Create an Account button
        driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Create an Account')]")).click();
        // Verify the text 'Thank you for registering with Main Website Store.’
        String expectedWelcomeMessage = "Thank you for registering with Main Website Store.";
        Assert.assertEquals(expectedWelcomeMessage,driver.findElement(By.xpath("//div[@class='page messages']//div[contains(@data-bind,'prepareMessageForHtml(message.text)')]")).getText());
        // Click on down aero neare Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@class='action switch']")).click();
        // Click on Sign Out link
        driver.findElement(By.xpath("//ul[@class='header links']//li[@class='authorization-link']/child::a")).click();
        // Verify the text ‘Youaresignedout’
        String expectedSignOutMessage = "You are signed out";
        String actualSignOutMessage = driver.findElement(By.xpath("//h1[@class='page-title']/child::span")).getText();
        Assert.assertEquals(expectedSignOutMessage,actualSignOutMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
