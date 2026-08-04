package helpers;

import org.example.RegisterAccount;

import java.util.Random;

public class TestDataGeneratorHelper {

    private static final Random random = new Random();

    private String name = "Продаю книгу";
    private String category = "Книги";
    private String condition = "БУ";
    private String city = "Новосибирск";
    private String description = "Старая книга";
    private String price = "10000";
    private String updatedName = "Новая книга";

    public static String generateEmail() {
        return "email" + random.nextInt(10000) + "@yandex.ru";
    }

    public static String generatePassword() {
        return "password" + random.nextInt(10000);
    }

    public static RegisterAccount generateRegisterAccount() {
        String email = generateEmail();
        String password = generatePassword();
        return new RegisterAccount(email, password, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getUpdatedName() {
        return updatedName;
    }
}