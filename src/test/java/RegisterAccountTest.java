import com.codeborne.selenide.Selenide;
import helpers.TestDataGeneratorHelper;
import org.example.RegisterAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePageDoska;
import pages.LoginPageDoska;
import pages.RegistrationPageDoska;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Deprecated
public class RegisterAccountTest {

    private HomePageDoska homePage;
    private LoginPageDoska loginPage;
    private RegistrationPageDoska registrationPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePageDoska();
        loginPage = new LoginPageDoska();
        registrationPage = new RegistrationPageDoska();
        homePage.openHomePage();
    }

    @Test
    @DisplayName("Успешная регистрация с уникальным email")
    public void registerAccountSucceed() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();

        homePage.clickLoginAndRegistration();
        loginPage.clickNoAccount();

        registrationPage.setEmail(account.getEmail());
        registrationPage.setPassword(account.getPassword());
        registrationPage.setSubmitPassword(account.getSubmitPassword());
        registrationPage.clickCreateAccount();

        homePage.waitForUserLoggedIn();
        assertTrue(homePage.isUserLoggedIn(),
                "Проверка, что после регистрации появился User.");
    }

    @Test
    @DisplayName("Регистрация с уже зарегистрированным email – ошибка")
    public void registerAccountDuplicateEmail() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();

        homePage.clickLoginAndRegistration();
        loginPage.clickNoAccount();
        registrationPage.setEmail(account.getEmail());
        registrationPage.setPassword(account.getPassword());
        registrationPage.setSubmitPassword(account.getSubmitPassword());
        registrationPage.clickCreateAccount();

        homePage.waitForUserLoggedIn();
        homePage.clickLogout();

        homePage.clickLoginAndRegistration();
        loginPage.clickNoAccount();
        registrationPage.setEmail(account.getEmail());
        registrationPage.setPassword(account.getPassword());
        registrationPage.setSubmitPassword(account.getSubmitPassword());
        registrationPage.clickCreateAccount();

        registrationPage.waitForErrorMessage("Ошибка");
        assertTrue(registrationPage.isErrorMessageDisplayed("Ошибка"),
                "Проверка, что при повторном входе отображается текст Ошибка");
    }

    @AfterEach
    public void cleanUp() {
        if (homePage.isUserLoggedIn()) {
            homePage.clickLogout();
        }
        Selenide.closeWebDriver();
    }
}