package com.demowebshop.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase extends ApplicationManager{

    @BeforeSuite
    public void setUp() {
        init();
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        stop();
    }

}
