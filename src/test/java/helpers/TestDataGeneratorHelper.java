package helpers;

import org.example.RegisterAccount;

import java.util.Random;

public class TestDataGeneratorHelper {

    private static final Random random = new Random();

    public static String generateEmail() {
        return "Email" + random.nextInt(10000) + "@yandex.ru";
    }

    public static String generatePassword() {
        return "Password" + random.nextInt(10000);
    }

    public static RegisterAccount generateRegisterAccount() {
        String email = generateEmail();
        String password = generatePassword();
        return new RegisterAccount(email, password, password);
    }
}
