package steps;

import helpers.TestDataGeneratorHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAnnouncementPageDoska;
import pages.HomePageDoska;
import pages.ProfilePageDoska;

public class CreateAnnouncementSteps {
    private final TestContext context;
    private final HomePageDoska homePage = new HomePageDoska();
    private final CreateAnnouncementPageDoska createAdPage = new CreateAnnouncementPageDoska();
    private final ProfilePageDoska profilePage = new ProfilePageDoska();

    public CreateAnnouncementSteps(TestContext context) {
        this.context = context;
    }

    @When("пользователь нажимает \"Разместить объявление\"")
    public void clickPlaceAnnouncement() {
        homePage.clickPlaceAnnouncement();
    }

    @And("пользователь заполняет данные объявления")
    public void fillAdData() {
        TestDataGeneratorHelper announcement = new TestDataGeneratorHelper();
        context.setAnnouncement(announcement);
        createAdPage.setName(announcement.getName());
        createAdPage.setDescription(announcement.getDescription());
        createAdPage.setPrice(announcement.getPrice());
    }

    @And("пользователь выбирает категорию")
    public void selectCategory() {
        createAdPage.openCategoryDropdown();
        createAdPage.selectCategory(context.getAnnouncement().getCategory());
    }

    @And("пользователь выбирает состояние {string}")
    public void selectCondition(String condition) {
        if ("БУ".equals(condition)) {
            createAdPage.selectConditionUsed();
        } else {
            createAdPage.selectConditionNew();
        }
    }

    @And("пользователь выбирает город")
    public void selectCity() {
        createAdPage.openCityDropdown();
        createAdPage.selectCity(context.getAnnouncement().getCity());
    }

    @And("пользователь нажимает \"Опубликовать\"")
    public void clickPublish() {
        createAdPage.clickPublish();
    }

    @When("пользователь переходит в Мой профиль")
    public void goToProfile() {
        homePage.clickProfile();
    }

    @And("пользователь находит объявление по названию")
    public void findAnnouncementByName() {
        profilePage.waitForAnnouncementCard(context.getAnnouncement().getName());
    }

    @Then("пользователь видит название объявления")
    public void verifyAnnouncementNameVisible() {
        profilePage.waitForAnnouncementCard(context.getAnnouncement().getName());
    }
}