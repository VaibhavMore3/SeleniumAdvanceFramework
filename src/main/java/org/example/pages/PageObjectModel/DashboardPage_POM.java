package org.example.pages.PageObjectModel;

import org.example.base.BasePage;
import org.example.drivers.DriverManagerTL;
import org.openqa.selenium.By;

public class DashboardPage_POM extends BasePage {

    By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");

    public String loggedInUsername(){
       presenceOfElement(userNameOnDashboard);
       return getElement(userNameOnDashboard).getText();

    }

    By profileButton = By.xpath("//img[@data-qa=\"user-image\"]");
    By logOutBtn = By.xpath("//li[@data-qa=\"logout-btn\"]");

    public void logOut(){
        presenceOfElement(profileButton).click();
        presenceOfElement(logOutBtn).click();
    }
}
