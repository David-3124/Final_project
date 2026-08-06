package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.HomePageDoska;
import pages.LoginPageDoska;

public class LoginSteps {
    private final TestContext context;
    private final HomePageDoska homePage = new HomePageDoska();
    private final LoginPageDoska loginPage = new LoginPageDoska();

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @When("пользователь нажимает \"Вход и регистрация\"")
    public void clickLoginAndRegistrationButton() {
        homePage.clickLoginAndRegistration();
    }

    @And("пользователь вводит email и пароль зарегистрированного пользователя")
    public void enterCredentials() {
        var account = context.getCurrentAccount();
        loginPage.setEmail(account.getEmail());
        loginPage.setPassword(account.getPassword());
    }

    @And("пользователь нажимает \"Войти\"")
    public void clickLoginButton() {
        loginPage.clickLogIn();
    }
}