package org.example.vwoLogin;

import org.assertj.core.api.Assertions;
import org.example.basetest.BaseTest;
import org.example.pages.PageObjectModel.DashboardPage_POM;
import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

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

}
