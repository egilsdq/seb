package com.example.leasingcalculator;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public static void setUpAll() {
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "1x1";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
    }
}
