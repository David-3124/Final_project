package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class EditAnnouncementPageDoska {
    private final SelenideElement nameField = $x("//input[@name='name']");
    private final SelenideElement saveButton = $x("//button[text()='Сохранить изменения']");

    public void waitForNameField() {
        nameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void clickSave() {
        saveButton.click();
    }
}