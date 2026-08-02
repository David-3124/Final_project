package helpers;

import org.example.RegisterAccount;

import java.util.Random;

public class TestDataGeneratorHelper {

    private static final Random random = new Random();

    public static String generateEmail() {
        return "Email_" + random.nextInt(10000) + "@yandex.ru";
    }

    public static String generatePassword() {
        return "Password_" + random.nextInt(10000);
    }

    public static RegisterAccount generateRegisterAccount() {
        String email = generateEmail();
        String password = generatePassword();
        return new RegisterAccount(email, password, password);
    }
}
