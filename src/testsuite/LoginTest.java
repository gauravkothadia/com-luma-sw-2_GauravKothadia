package testsuite;
/**
 * 4. Write down the following test into ‘LoginTest’
 *  class
 * 1. userShouldLoginSuccessfullyWithValid
 *  Credentials()
 *  * Click on ‘Sign In’ link
 *  * Enter valid Email
 *  * Enter valid Password
 *  * Click on ‘Sign In’ button
 *  * Verify the ‘Welcome’ text is display
 *  2. verifyTheErrorMessageWithInvalidCredentials
 *  * Click on ‘Sign In’ link
 *  * Enter valid Email
 *  * Enter valid Password
 *  * Click on ‘Sign In’ button
 *  * Verify the error message ‘Theaccountsign-inwas
 *  incorrect or your account is disabled temporarily. Please wait and try again
 *  later.’
 *  3. userShouldLogOutSuccessfully
 *  * Click on ‘Sign In’ link
 *  * Enter valid Email
 *  * Enter valid Password
 *  * Click on ‘Sign In’ button
 *  * Verify the ‘Welcome’ text is display
 *  * Click on down aero neare Welcome
 *  * Click on Sign Out link
 *  * Verify the text ‘Youaresignedout’
 */

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Before
    public void browserSetup() {
        openBrowser("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials1() {
        // Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//a[contains(text(),'Sign In')]")).click();
        // Enter valid Email
        driver.findElement(By.name("login[username]")).sendKeys("gaurav123@gmail.com");
        // Enter valid Password
        driver.findElement(By.name("login[password]")).sendKeys("gaurav123@");
        // Click on ‘Sign In’ button
        driver.findElement(By.xpath("//div[@class='login-container']//button//span[text()='Sign In']")).click();
        // Verify the ‘Welcome’ text is display
        String expectedWelcomeMessage = "Welcome";
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//span[@class='logged-in']")).getText().contains(expectedWelcomeMessage));
    }

   @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
       // Click on ‘Sign In’ link
       driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//a[contains(text(),'Sign In')]")).click();
       // Enter valid Email
       driver.findElement(By.name("login[username]")).sendKeys("gaurav123@gmail.com");
       // Enter valid Password
       driver.findElement(By.name("login[password]")).sendKeys("gaurav123000!");
       // Click on ‘Sign In’ button
       driver.findElement(By.xpath("//div[@class='login-container']//button//span[text()='Sign In']")).click();
        // Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.’
       String expectedLoginErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
       String actualLoginErrorMessage = driver.findElement(By.xpath("//div[@class='page messages']//div[@class='message-error error message']/child::div")).getText();
       Assert.assertEquals(expectedLoginErrorMessage,actualLoginErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//a[contains(text(),'Sign In')]")).click();
        // Enter valid Email
        driver.findElement(By.name("login[username]")).sendKeys("gaurav123@gmail.com");
        // Enter valid Password
        driver.findElement(By.name("login[password]")).sendKeys("gaurav123@");
        // Click on ‘Sign In’ button
        driver.findElement(By.xpath("//div[@class='login-container']//button//span[text()='Sign In']")).click();
        // Verify the ‘Welcome’ text is display
        String expectedWelcomeMessage = "Welcome";
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//span[@class='logged-in']")).getText().contains(expectedWelcomeMessage));
        // Click on down aero neare Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@class='action switch']")).click();
        // Click on Sign Out link
        driver.findElement(By.xpath("//ul[@class='header links']//li[@class='authorization-link']/child::a")).click();
        // Verify the text ‘You are signed out’
        String expectedSignOutMessage = "You are signed out";
        String actualSignOutMessage = driver.findElement(By.xpath("//h1[@class='page-title']/child::span")).getText();
        Assert.assertEquals(expectedSignOutMessage,actualSignOutMessage);
    }

    @After
    public void tearDown() {
      closeBrowser();
    }
}