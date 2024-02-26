package org.example.pages.PageObjectModel;

import org.example.base.BasePage;
import org.example.drivers.DriverManagerTL;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage_POM extends BasePage {

    public LoginPage_POM(){
        super();
    }

    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");
    By errorMsg = By.id("js-notification-box-msg");


    public void openURL(String url){
        DriverManagerTL.getDriver().get(url);
    }

    public LoginPage_POM LoginToVWOPositive() throws Exception {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password,PropertyReader.readKey("password"));
        clickElement(signButton);
        return this;
    }

    public String LoginToVWONegative() throws Exception {
        enterInput(username, "admin");
        enterInput(password,PropertyReader.readKey("password"));
        clickElement(signButton);
        // return error string
       visibilityOfElement(errorMsg);
       return getElement(errorMsg).getText();
    }

    public DashboardPage_POM afterLogin(){
        return new DashboardPage_POM();
    }
}
