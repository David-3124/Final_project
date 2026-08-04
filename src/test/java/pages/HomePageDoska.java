package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePageDoska {
    private final SelenideElement loginAndRegistrationButton = $x("//button[text()='Вход и регистрация']");
    private final SelenideElement placeAnnouncementButton = $x("//button[text()='Разместить объявление']");
    private final SelenideElement userProfileName = $x("//h3[@class='profileText name' and contains(text(),'User.')]");
    private final SelenideElement logoutButton = $x("//button[@class='spanGlobal btnSmall' and text()='Выйти']");
    private final SelenideElement profileButton = $x("//button[@class='circleSmall']");

    public void clickLoginAndRegistration() {
        loginAndRegistrationButton.click();
    }

    public void clickPlaceAnnouncement() {
        placeAnnouncementButton.click();
    }

    public void openHomePage() {
        open(config.Endpoints.PAGE_URL);
    }

    public boolean isUserLoggedIn() {
        return userProfileName.isDisplayed();
    }

    public void waitForUserLoggedIn() {
        userProfileName.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void clickProfile() {
        profileButton.click();
    }
}