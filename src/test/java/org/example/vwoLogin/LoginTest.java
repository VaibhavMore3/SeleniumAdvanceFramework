package org.example.vwoLogin;

import org.assertj.core.api.Assertions;
import org.example.basetest.BaseTest;
import org.example.drivers.DriverManagerTL;
import org.example.pages.PageObjectModel.DashboardPage_POM;
import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.URL;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test (priority = 1)
    public void testLoginNegative() throws Exception {

        LoginPage_POM pagePom = new LoginPage_POM();
        pagePom.openURL(PropertyReader.readKey("url"));

        String error_message = pagePom.LoginToVWONegative();
        Assertions.assertThat(error_message).isNotNull().isNotBlank().contains(PropertyReader.readKey("error_message"));

    }

    @Test (priority = 2)
    public void testLoginPositive() throws Exception {

        LoginPage_POM pagePom = new LoginPage_POM();
        pagePom.openURL(PropertyReader.readKey("url"));

        DashboardPage_POM dashboardPagePom = pagePom.LoginToVWOPositive().afterLogin();
        String expected_user = dashboardPagePom.loggedInUsername();
        Assertions.assertThat(expected_user).isNotNull().isNotBlank().contains(PropertyReader.readKey("expected_username"));
    }
    @Test (priority = 3)
    public void testLogOut() throws Exception {
        testLoginPositive();
        DashboardPage_POM logOutTest = new DashboardPage_POM();
        logOutTest.logOut();

        String expected_url = "https://app.vwo.com/#/login";
        new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlMatches(expected_url));
        String actual_url = DriverManagerTL.getDriver().getCurrentUrl();
        Assertions.assertThat(actual_url).isEqualTo(expected_url);
        System.out.println(actual_url);
        System.out.println(expected_url);
    }

}
