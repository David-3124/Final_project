import config.BaseUrl;
import helpers.RegisterAccountHelper;
import helpers.TestDataGeneratorHelper;
import org.example.RegisterAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Deprecated
public class ApiTest extends BaseUrl {

    @Test
    @DisplayName("Проверка работоспособности API регистрации")
    public void testApiRegistration() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();
        System.out.println("REQUEST BODY: " + account);
        RegisterAccount createdAccount = RegisterAccountHelper.registerNewUser(
                account.getEmail(),
                account.getPassword(),
                account.getSubmitPassword()
        );
        assertNotNull(createdAccount, "Аккаунт должен быть создан через API");
    }
}