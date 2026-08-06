package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePageDoska {
    private final SelenideElement editButton = $x("//button[@class='editButton']");
    private final SelenideElement announcementPictureButton = $x("/html/body/div/div/div[2]/div[4]/div/div[1]/div/img");
    private final SelenideElement emptyAnnouncements = $x("//h2[text()='Здесь пока пусто...']");

    public void waitForAnnouncementCard(String name) {
        $x("//*[contains(text(),'" + name + "')]").shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void clickEdit() {
        editButton.click();
    }

    public void clickAnnouncementPicture() {
        announcementPictureButton.click();
    }

    public void waitForEmptyAnnouncements() {
        emptyAnnouncements.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}