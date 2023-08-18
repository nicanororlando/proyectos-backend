import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class SeleniumConcepts {
    public static void main(String[] args) {
        String pageUrl = "https://nicanororlando.github.io/portfolio/";

        // *NO NEED OF THIS
        // System.setProperty("webdriver.chrome.driver", "C:/repo/test/webdrivers/chromedriver");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // get("url") loads a new page in the current browser window.
        driver.get(pageUrl);

        // behaves the same way as get("url")
        //driver.navigate().to(pageUrl);
        //driver.navigate().forward();
        //driver.navigate().back();
        //driver.navigate().refresh();

        // getTitle() used to retrieve the title of the webpage the user is currently working on
        String title = driver.getTitle();
        System.out.println("title: " + title);  // "Portfolio Website"

        // getCurrentUrl() To obtain the URL of the webpage the user is currently accessing.
        String url = driver.getCurrentUrl();
        System.out.println("url: " + url);  // "https://nicanororlando.github.io/portfolio/en"

        // getPageSource() Returns the source code of the webpage
        String pageSource = driver.getPageSource();

        // It simulates a click user to the "slider" button
        driver.findElement(By.className("slider")).click();

        // Return the social button links, and click all buttons (this will open a new tab).
        driver.findElements(By.className("social-icon")).get(1).click();

        // To store the base window handle
        String base = driver.getWindowHandle();
        System.out.println("base window handle: " + base);

        // Get the window handle for all opened windows
        Set<String> handles = driver.getWindowHandles();

        driver.switchTo().window(base); // It returns to the base window
        driver.switchTo().window((String) handles.toArray()[1]);    // It returns to the opened window
        driver.switchTo().window(base); // It returns to the base window again

        // driver.close() closes the browser window without ending the session or killing driver instance
        // driver.quit() kills our session, the driver instance and the browser window.

        /* Find by XPath
        *
        * ABSOLUTE path: XPath = /tagName[@atribute=value]
        *   / - Point to the first node on the HTML Document
        *   @example: /html/body/div[2]/div/label
        *
        * RELATIVE path: XPath = //tagName[@atribute=value]
        *   // - Point to the any node in the webpage
        *   @example: //div[@class='form-group']/input[@id='0user-msg']
        *
        * @ : Allows us to select any attribute
        *   @example: tagName[@attribute='value']
        *
        * * : We can use it instead ot tagName and attribute
        *
        */
        // driver.findElement(By.xpath("//*[@className='slider']")).click();
    }
}
