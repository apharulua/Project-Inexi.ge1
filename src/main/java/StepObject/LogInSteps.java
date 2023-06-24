package StepObject;

import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInSteps extends LoginPage {
    WebDriver driver;
    public LogInSteps(WebDriver driver1) {
        driver = driver1;
    }


    public void EmailInput (String email) {
        driver.findElement(emailField).sendKeys(email);


    }

    public void  PasswordInput (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void LogInButton() {
        driver.findElement(loginField).click();
    }
}
