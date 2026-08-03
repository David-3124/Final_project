package steps;

import org.example.RegisterAccount;

public class TestContext {
    private RegisterAccount currentAccount;

    public RegisterAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(RegisterAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}