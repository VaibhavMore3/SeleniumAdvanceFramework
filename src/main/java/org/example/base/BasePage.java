package org.example.base;

import org.example.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public BasePage(){

    }

    public void implicitWait(){
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickElement(By by){
        DriverManager.getDriver().findElement(by).click();
    }

    public WebElement presenceOfElement(final By elementLocation){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public WebElement visibilityOfElement(final By elementLocation){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected void enterInput(By by, String key){
        DriverManager.getDriver().findElement(by).sendKeys(key);
    }

    protected WebElement getElement(By key){
       return DriverManager.getDriver().findElement(key);
    }
}
