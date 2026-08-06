package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPageDoska {
    private final SelenideElement emailField = $x("//input[@name='email']");
    private final SelenideElement passwordField = $x("//input[@name='password']");
    private final SelenideElement submitPasswordField = $x("//input[@name='submitPassword']");
    private final SelenideElement createAccountButton = $x("//button[text()='Создать аккаунт']");
    private final SelenideElement alreadyAccountButton = $x("//button[text()='Уже есть аккаунт']");

    public void setEmail(String email) {
        emailField.setValue(email);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void setSubmitPassword(String submitPassword) {
        submitPasswordField.setValue(submitPassword);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public void clickAlreadyAccount() {
        alreadyAccountButton.click();
    }

    public void waitForErrorMessage(String expectedText) {
        $x("//*[contains(text(),'" + expectedText + "')]").shouldBe(Condition.visible);
    }

    public boolean isErrorMessageDisplayed(String expectedText) {
        return $x("//*[contains(text(),'" + expectedText + "')]").isDisplayed();
    }
}