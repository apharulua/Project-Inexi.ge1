import StepObject.LogInSteps;
import Utilities.ChromeRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


import static StoringData.loginData.*;

public class    Login extends ChromeRunner {

    @Test


    public void logInWithIncorrectData() throws InterruptedException {

        // ეს ფინალურისთვის ჩავამატო if  და boolean - ები; driver.findElement(By.id("hide-news-popup")).click();
        String incorrectEmail = "შეიყვანეთ მოქმედი ელ.ფოსტა";
        String incorrectPassword = "პაროლი არასწორია";

        LogInSteps step1 = new LogInSteps(driver);
        step1.EmailInput(IncorrectEmailData);
        step1.PasswordInput(IncorrectPasswordData);
        step1.LogInButton();
        Thread.sleep(5000);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/main/div/div/div/div/form/div/div[1]/label"))));
        driver.findElement(By.id("email")).sendKeys("test@test.ge");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/form/div/button"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("შეიყვანეთ მოქმედი ელ.ფოსტა"))));

        String actualErrorMessage = driver.findElement(By.className("შეიყვანეთ მოქმედი ელ.ფოსტა")).getText();
        String expectedErrorMessage = "მომხმარებლის ელ.ფოსტა ან პაროლი არასწორია";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


    }




    @Test
    public void logInWithCorrectData() throws InterruptedException {

        LogInSteps step2 = new LogInSteps(driver);
        step2.EmailInput(CorrectEmailData);
        step2.PasswordInput(CorrectPasswordData);
        step2.LogInButton();
         Thread.sleep(5000);



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("https://inexi.ge/ka/room/parcels"))));
        driver.findElement(By.id("email")).sendKeys("apharulua@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Pegasusi555");
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/form/div/button"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("მომხმარებლი დალოგინდა თავის ანგარიშზე"))));

        String actualErrorMessage1 = driver.findElement(By.className("დალოგინდა მომხმარებლის ანგარიშზე")).getText();
        String expectedErrorMessage1 = "მომხმარებლი დალოგინდა თავის ანგარიშზე";

        Assert.assertEquals(actualErrorMessage1, expectedErrorMessage1);


    }
}