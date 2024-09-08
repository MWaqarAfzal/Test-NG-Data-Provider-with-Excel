package dataprovider;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowsauthenticationpopupalerts {
    public static WebDriver driver;
    public static void main(String [] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup(); // This should be called before initializing the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser and set timeout
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://the-internet.herokuapp.com/");
        //      Modified URL by providing the UserName and Password
        driver.get("https://admin:admin@the-internet.herokuapp.com");
        driver.findElement(By.linkText("Basic Auth")).click();

    }

}
