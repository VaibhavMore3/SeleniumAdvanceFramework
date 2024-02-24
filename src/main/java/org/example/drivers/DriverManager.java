package org.example.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static  WebDriver driver;


    public static void init(){
        if (driver ==null){
            driver = new ChromeDriver();
        }
    }

    public  WebDriver getDriver(){
        return driver;
    }

    public static void down(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
