package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePageDoska {
    private final SelenideElement editButton = $x("//button[@class='editButton']");

    public void waitForAnnouncementCard(String name) {
        $x("//*[contains(text(),'" + name + "')]").shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void clickEdit() {
        editButton.click();
    }
}