package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePageDoska;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {
    private HomePageDoska homePage = new HomePageDoska();

    @Given("пользователь открывает главную страницу")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Then("пользователь видит свой профиль на главной странице")
    public void verifyProfileVisible() {
        homePage.waitForUserLoggedIn();
        assertTrue(homePage.isUserLoggedIn(), "Профиль User. должен отображаться");
    }
}