package org.example.basetest;

import org.example.drivers.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManagerTL {

    @BeforeMethod
    protected void setUp(){
        DriverManagerTL.init();
    }


    @AfterMethod
    protected void tearDown(){
        DriverManagerTL.down();
    }
}
