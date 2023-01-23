package com.example.leasingcalculator;

import com.codeborne.selenide.WebDriverRunner;
import com.example.leasingcalculator.Pages.MainPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setUp() {
        open(mainPage.pageUrl);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }

    @Test
    public void test() {

    }
}
