package org.example.pages.PageObjectModel;

import org.example.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage_POM extends BasePage {

    By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");

    public String loggedInUsername(){
       presenceOfElement(userNameOnDashboard);
       return getElement(userNameOnDashboard).getText();

    }
}
