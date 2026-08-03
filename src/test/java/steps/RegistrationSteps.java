package steps;

import helpers.TestDataGeneratorHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.RegisterAccount;
import pages.HomePageDoska;
import pages.LoginPageDoska;
import pages.RegistrationPageDoska;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationSteps {
    private final TestContext context;
    private HomePageDoska homePage = new HomePageDoska();
    private LoginPageDoska loginPage = new LoginPageDoska();
    private RegistrationPageDoska registrationPage = new RegistrationPageDoska();

    public RegistrationSteps(TestContext context) {
        this.context = context;
    }

    @When("пользователь переходит на форму регистрации")
    public void goToRegistrationForm() {
        homePage.clickLoginAndRegistration();
        loginPage.clickNoAccount();
    }

    @And("пользователь заполняет поля: email, password, submitPassword")
    public void fillRegistrationFields() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();
        context.setCurrentAccount(account);
        registrationPage.setEmail(account.getEmail());
        registrationPage.setPassword(account.getPassword());
        registrationPage.setSubmitPassword(account.getSubmitPassword());
    }

    @And("пользователь нажимает \"Создать аккаунт\"")
    public void clickCreateAccountButton() {
        registrationPage.clickCreateAccount();
    }

    @When("пользователь регистрируется с уникальными данными")
    public void registerWithUniqueData() {
        goToRegistrationForm();
        fillRegistrationFields();
        clickCreateAccountButton();
        homePage.waitForUserLoggedIn();
    }

    @And("пользователь выходит из аккаунта")
    public void logout() {
        homePage.clickLogout();
    }

    @And("пользователь заполняет те же данные")
    public void fillSameRegistrationFields() {
        RegisterAccount account = context.getCurrentAccount();
        registrationPage.setEmail(account.getEmail());
        registrationPage.setPassword(account.getPassword());
        registrationPage.setSubmitPassword(account.getSubmitPassword());
    }

    @Then("пользователь видит сообщение об ошибке {string}")
    public void verifyErrorMessage(String expectedText) {
        registrationPage.waitForErrorMessage(expectedText);
        assertTrue(registrationPage.isErrorMessageDisplayed(expectedText),
                "Должно отображаться сообщение об ошибке с текстом: " + expectedText);
    }
}