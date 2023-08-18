import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Ej03_WindowManagement {
    public static void main(String[] args) {
        String pageUrl = "https://nicanororlando.github.io/portfolio/";
        WebDriver driver = new ChromeDriver();
        driver.get(pageUrl);

        // To store the base window handle
        String base = driver.getWindowHandle();
        System.out.println("base window handle: " + base);

        // Lets find the social-buttons:
        // ❌ The following will "fail" 👇 because we have other buttons with the 'social-icon' class
        //driver.findElements(By.className("social-icon")).forEach(WebElement::click);

        // ✅ We have other social-buttons in our App, so if we want to only select wanted
        // 1. Get the container (using XPATH expression)
        WebElement containerSocialButtons = driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center']"));
        // 2. Get the elements within the container
        List<WebElement> socialButtons = containerSocialButtons.findElements(By.xpath("./child::*"));
        // 3. Click on the elements (This will open 3 new tabs)
        socialButtons.forEach(WebElement::click);

        // Get the window handle for all opened windows
        Set<String> handles = driver.getWindowHandles();

        // I remove the base because I want to close only the other windows
        handles.remove(base);

        // Then I iterate over the set, to close the opened windows
        for (String handle : handles) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
}
