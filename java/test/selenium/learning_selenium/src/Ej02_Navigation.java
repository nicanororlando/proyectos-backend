import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ej02_Navigation {
    public static void main(String[] args) {
        String link = "https://en.wikipedia.org/";

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open "https://en.wikipedia.org/"
        driver.get(link);

        // Click on Wikipedia link using "driver.findElement(By.linkText("Wikipedia")).click();"
        driver.findElement(By.linkText("Wikipedia")).click();

        // Come back to home using "back" command
        driver.navigate().back();

        // Go back to Wikipedia using "forward" command
        driver.navigate().forward();

        // Come back to home using "to" command
        driver.navigate().to(link);

        // Refresh the browser using "refresh" command
        driver.navigate().refresh();

        driver.quit();
    }
}
