package org.example.pages.PageObjectModel;

import org.example.base.BasePage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage_POM extends BasePage {

    public LoginPage_POM(){
        super();
    }

    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");

    public LoginPage_POM LoginToVWOPositive() throws Exception {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password,PropertyReader.readKey("password"));
        clickElement(signButton);
        return this;
    }

    public void LoginToVWONegative() throws Exception {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password,PropertyReader.readKey("password"));
        clickElement(signButton);
        // return error string
    }

    public DashboardPage_POM afterLogin(){
        return new DashboardPage_POM();
    }
}
