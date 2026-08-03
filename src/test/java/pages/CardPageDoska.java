package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CardPageDoska {
    private final SelenideElement editAdButton = $x("//button[text()='Редактировать объявление']");
    private final SelenideElement deleteAdButton = $x("//button[text()='Удалить']");

    public void clickEditAd() {
        editAdButton.click();
    }

    public void clickDeleteAd() {
        deleteAdButton.click();
    }

    public boolean isEditAdButtonVisible() {
        return editAdButton.isDisplayed();
    }

    public boolean isDeleteAdButtonVisible() {
        return deleteAdButton.isDisplayed();
    }
}