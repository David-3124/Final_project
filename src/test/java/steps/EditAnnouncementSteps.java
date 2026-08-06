package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.EditAnnouncementPageDoska;
import pages.HomePageDoska;
import pages.ProfilePageDoska;

public class EditAnnouncementSteps {
    private final TestContext context;
    private final HomePageDoska homePage = new HomePageDoska();
    private final ProfilePageDoska profilePage = new ProfilePageDoska();
    private final EditAnnouncementPageDoska editPage = new EditAnnouncementPageDoska();

    public EditAnnouncementSteps(TestContext context) {
        this.context = context;
    }

    @When("пользователь нажимает \"Редактировать\"")
    public void clickEdit() {
        profilePage.clickEdit();
    }

    @And("пользователь изменяет название объявления")
    public void changeName() {
        editPage.waitForNameField();
        editPage.setName(context.getAnnouncement().getUpdatedName());
        context.getAnnouncement().setName(context.getAnnouncement().getUpdatedName());
    }

    @And("пользователь нажимает \"Сохранить изменения\"")
    public void clickSave() {
        editPage.clickSave();
    }
}