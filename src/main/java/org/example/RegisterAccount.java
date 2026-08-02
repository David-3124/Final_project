package org.example;

public class RegisterAccount {
    private String email;
    private String password;
    private String submitPassword;

    public RegisterAccount(String email, String password, String submitPassword) {
        this.submitPassword = submitPassword;
        this.password = password;
        this.email = email;
    }

    public RegisterAccount() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubmitPassword() {
        return submitPassword;
    }

    public void setSubmitPassword(String submitPassword) {
        this.submitPassword = submitPassword;
    }
}
