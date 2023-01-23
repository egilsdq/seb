package com.example.leasingcalculator.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.util.concurrent.TimeUnit;

public class Helper {
    public static void SwitchToFrame(SelenideElement element) {
        WebDriverRunner.driver().switchTo().frame(element);
    }

    public static void ClickWithNoWait(SelenideElement element) {
        try {
            WebDriverRunner.driver().getWebDriver().manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
            WebDriverRunner.driver().executeJavaScript("arguments[0].click();", element);
        } catch (Exception ex) { }
    }
}
