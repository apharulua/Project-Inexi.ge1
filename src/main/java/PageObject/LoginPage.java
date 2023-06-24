package PageObject;

import org.openqa.selenium.By;

public class LoginPage {

    protected
    By
    emailField=By.name("email"),
    passwordField=By.id("password"),
    loginField=By.xpath("/html/body/main/div/div/div/div/form/div/button");

}
