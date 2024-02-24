package org.example.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

public class DriverManagerTL {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver(){
      return dr.get();
    }

    //Unload
    public static void unload(){
        dr.remove();
    }

    public static void down(){
        if(Objects.nonNull(DriverManagerTL.getDriver())){
            getDriver().quit();
            unload();
        }
    }

    public static void init(){
        if (Objects.isNull(DriverManagerTL.getDriver())){
            WebDriver driver = new ChromeDriver();
            setDriver(driver);
        }
    }
}
