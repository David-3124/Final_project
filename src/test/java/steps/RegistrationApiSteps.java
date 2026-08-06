package steps;

import helpers.RegisterAccountHelper;
import helpers.TestDataGeneratorHelper;
import io.cucumber.java.en.Given;
import org.example.RegisterAccount;

public class RegistrationApiSteps {
    private final TestContext context;

    public RegistrationApiSteps(TestContext context) {
        this.context = context;
    }

    @Given("пользователь зарегистрирован с уникальными данными через API")
    public void registerUserViaApi() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();
        RegisterAccountHelper.registerNewUser(
                account.getEmail(),
                account.getPassword(),
                account.getSubmitPassword()
        );
        context.setCurrentAccount(account);
    }
}