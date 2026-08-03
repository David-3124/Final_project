package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import pages.HomePageDoska;

public class CleanUp {
    @After
    public void cleanUp() {
        HomePageDoska homePage = new HomePageDoska();
        if (homePage.isUserLoggedIn()) {
            homePage.clickLogout();
        }
        Selenide.closeWebDriver();
    }
}