package browserfactory;
/**
 *  Project-6- ProjectName : com-luma-sw-2
 *  BaseUrl = https://magento.softwaretestingboard.com/
 *  1. Create the package ‘browserfactory’ and create the
 *  class with the name ‘BaseTest’ inside the
 *  ‘browserfactory’ package. And write the browser setup
 *  code inside the class ‘Base Test’.
 *  2. Create the package ‘testsuite’ and create the
 *  following classes inside the ‘testsuite’ package.
 *  1. RegisterTest
 *  2. LoginTest
 *  3. SaleTest
 *  3. Write down the following test into ‘RegisterTest’
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
 *  4. Write down the following test into ‘LoginTest’
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
 *  5.Write down the following test into ‘SaleTest’ class
 *  1. verifyTheTotalItemsDisplayedOnTheWomens
 *  JacketsPage()
 *  * Click on ‘Sale’ Menu tab
 *  * Click on ‘Jackets’ link on left side
 *  under WOMEN’S DEAL Category
 *  * Verify the text ‘Jackets’ is displayed
 *  * Count the Total Item Displayed on Page
 *  and print the name of all items into
 *  console.
 *  * Verify total 12 Items displayed on page.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        // Launch the Chrome Browser
        driver = new ChromeDriver();
        // Open the URL into Browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        // We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}