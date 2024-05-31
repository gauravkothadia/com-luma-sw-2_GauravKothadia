package testsuite;
/**
 *   5.Write down the following test into ‘SaleTest’ class
 *  1. verifyTheTotalItemsDisplayedOnTheWomens
 *  JacketsPage()
 *  * Click on ‘Sale’ Menu tab
 *  * Click on ‘Jackets’ link on left side
 *  under WOMEN’S DEAL Category
 *  * Verify the text ‘Jackets’ is displayed
 *  * Count the Total Item Displayed on Page
 *  and print the name of all items into
 *  console.
 *  * Verify total 12 Items displayed on page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class SaleTest extends BaseTest {

    @Before
    public void browserSetup(){
        openBrowser("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        // Click on ‘Sale’ Menu tab
        driver.findElement(By.xpath("//div[@id='store.menu']//span[contains(text(),'Sale')]")).click();
        // Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.cssSelector("div.categories-menu ul li>a[href*='jackets-women']")).click();
        // Verify the text ‘Jackets’ is displayed
        String expectedTitle = "Jackets";
        String actualTitle = driver.findElement(By.cssSelector("h1.page-title>span")).getText();
        Assert.assertEquals(expectedTitle,actualTitle);
        // Count the Total Item Displayed on Page and print the name of all items into console.
        List<WebElement> jacketItems = driver.findElements(By.cssSelector("li.item.product.product-item a.product-item-link"));
        System.out.println("Total jackets displayed : "+jacketItems.size());
        System.out.println("-------------------------");
        for(WebElement ele: jacketItems){
            System.out.println(ele.getText());
        }
        // Verify total 12 Items displayed on page
        int expectedDisplayedItemOnPage = 12;
        Assert.assertEquals(expectedDisplayedItemOnPage,jacketItems.size());
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
