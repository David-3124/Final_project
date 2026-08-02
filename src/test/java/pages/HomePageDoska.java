package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePageDoska {
    private final SelenideElement loginAndRegistrationButton = $x("//button[text()='Вход и регистрация']");
    private final SelenideElement placeAnnouncementButton = $x("//button[text()='Разместить объявление']");

    public void clickLoginAndRegistration() {
        loginAndRegistrationButton.click();
    }

    public void clickPlaceAnnouncement() {
        placeAnnouncementButton.click();
    }
}