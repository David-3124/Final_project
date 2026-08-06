package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CardPageDoska;
import pages.ProfilePageDoska;

public class DeleteAnnouncementSteps {
    private final ProfilePageDoska profilePage = new ProfilePageDoska();
    private final CardPageDoska cardPage = new CardPageDoska();

    @And("пользователь открывает карточку объявления")
    public void openAnnouncementCard() {
        profilePage.clickAnnouncementPicture();
    }

    @And("пользователь нажимает \"Удалить\"")
    public void clickDelete() {
        cardPage.clickDeleteAd();
    }

    @Then("пользователь видит, что объявлений нет")
    public void verifyNoAnnouncements() {
        profilePage.waitForEmptyAnnouncements();
    }
}