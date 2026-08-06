package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageDoska {
    private final SelenideElement emailField = $x("//input[@name='email']");
    private final SelenideElement passwordField = $x("//input[@name='password']");
    private final SelenideElement logInButton = $x("//button[text()='Войти']");
    private final SelenideElement noAccountButton = $x("//button[text()='Нет аккаунта']");

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogIn() {
        logInButton.click();
    }

    public void clickNoAccount() {
        noAccountButton.click();
    }
}