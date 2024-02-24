package org.example.basetest;

import org.example.drivers.DriverManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManager{

    @BeforeMethod
    protected void setUp(){
        DriverManager.init();
    }

    protected void tearDown(){
        DriverManager.down();
    }
}
