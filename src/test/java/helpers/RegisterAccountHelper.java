package helpers;

import config.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.RegisterAccount;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterAccountHelper {

    @Step("Создание пользователя с проверкой успеха")
    public static RegisterAccount registerNewUser(String email, String password, String submitPassword) {
        RegisterAccount account = new RegisterAccount(email, password, submitPassword);
        Response response = registerUserRequest(account);
        response.then()
                .statusCode(201)
                .body("user.id", notNullValue());
        return account;
    }

    @Step("Запрос на регистрацию пользователя")
    public static Response registerUserRequest(RegisterAccount account) {
        return given()
                .contentType("application/json")
                .body(account)
                .when()
                .post(Endpoints.REGISTER_ACCOUNT);
    }
}