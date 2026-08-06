package steps;

import helpers.TestDataGeneratorHelper;
import org.example.RegisterAccount;

public class TestContext {
    private RegisterAccount currentAccount;
    private TestDataGeneratorHelper announcement;

    public RegisterAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(RegisterAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public TestDataGeneratorHelper getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(TestDataGeneratorHelper announcement) {
        this.announcement = announcement;
    }
}