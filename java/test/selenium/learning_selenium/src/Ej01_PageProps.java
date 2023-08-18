import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public class Ej01_PageProps {
    public static void main(String[] args) {

        // 1. Launch a new Chrome browser
        WebDriver driver = new ChromeDriver();

        // 2. Open the link: https://www.economist.com/
        String economistLink = "https://www.economist.com/";
        driver.get(economistLink);

        // 3. Get page Title name and Title length
        String pageTitle = driver.getTitle();

        // 4. Print both on the console
        System.out.println(pageTitle + pageTitle.length());

        // 5. Get page URL and verify if it is a correct page opened
        if(!Objects.equals(driver.getCurrentUrl(), economistLink)) System.out.println("Wrong page opened");
        else System.out.println("Good shape");

        // 6. Get page source and page source length
        String pageSource = driver.getPageSource();
        Number pageSourceLength = pageSource.length();

        // 7 Print page length on console
        System.out.println(pageSourceLength + " bytes");

        // 8. Close the browser
        driver.quit();
    }
}
