import config.BaseUrl;
import helpers.RegisterAccountHelper;
import helpers.TestDataGeneratorHelper;
import io.restassured.response.Response;
import org.example.RegisterAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class RegisterAccountTest extends BaseUrl {

    @Test
    @DisplayName("Успешная регистрация с уникальным email")
    public void registerAccountSucceed() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();
        Response response = RegisterAccountHelper.registerUserRequest(account);
        response.then()
                .statusCode(201)
                .body("user.id", notNullValue());
    }

    @Test
    @DisplayName("Регистрация с уже существующим email, ошибка 400")
    public void registerAccountDuplicateEmail() {
        RegisterAccount account = TestDataGeneratorHelper.generateRegisterAccount();

        RegisterAccountHelper.registerUserRequest(account).then().statusCode(201);

        Response response = RegisterAccountHelper.registerUserRequest(account);
        response.then()
                .statusCode(400)
                .body("message", notNullValue());
    }
}