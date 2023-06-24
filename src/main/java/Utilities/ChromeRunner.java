package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ChromeRunner {
     public static WebDriver driver = new ChromeDriver();
    @BeforeTest
     public void OpenChrome() {
        driver.manage().window().maximize();
        driver.get("https://inexi.ge/ka/login");

    }

   @AfterTest
    public void CloseChrome(){
        driver.close();

   }
}
