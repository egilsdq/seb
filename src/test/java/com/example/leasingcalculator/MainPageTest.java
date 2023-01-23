package com.example.leasingcalculator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.example.leasingcalculator.Pages.Helper;
import com.example.leasingcalculator.Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public void setUp() {
        open(mainPage.pageUrl);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();

        // agree to cookies
        if (mainPage.agreeToCookies.exists()) {
            mainPage.agreeToCookies.click();
        }

        Helper.SwitchToFrame(mainPage.calculatorFrame);
    }

    @DataProvider (name = "purchase-value-verification")
    public Object[][] purchaseValueVerificationDataProvider(){
        return new Object[][] {
            { "8000.1", null },
            {"", "Wrong data format"},
            {"0", "For amount up to 8 000 EUR we offer consumer loan"},
            {"a", "Wrong data format. The number must be greater than 0!"}
        };
    }

    @Test (priority = 1,
        dataProvider = "purchase-value-verification",
        testName = "Verify if a user can/cannot see calculation when enter purchase value")
    public void testPurchaseValueVerification(String val, String error) {
        mainPage.purchaseValue.clear();
        mainPage.purchaseValue.sendKeys(val);
        mainPage.calculate.click();

        if (error == null) {
            Assert.assertNotEquals(mainPage.monthlyPaymentResult.getText(), "-");
            Assert.assertNotEquals(mainPage.commisionResult.getText(), "-");
            Assert.assertNotEquals(mainPage.firstInstallmentResult.getText(), "-");
        } else {
            Assert.assertEquals(mainPage.purchaseValueError.getText(), error);
            Assert.assertEquals(mainPage.monthlyPaymentResult.getText(), "-");
            Assert.assertEquals(mainPage.commisionResult.getText(), "-");
            Assert.assertEquals(mainPage.firstInstallmentResult.getText(), "-");
        }
    }

    @Test (priority = 10,
        testName = "Verify if a user can see payment schedule print window displayed")
    public void testPrintPaymentSchedule() {
        // run calculation
        mainPage.purchaseValue.clear();
        mainPage.purchaseValue.sendKeys("8000");
        // TODO: Need to remove this after fix of verification form
        mainPage.purchaseValue.parent().click();
        mainPage.calculate.click();

        Assert.assertNotEquals(mainPage.monthlyPaymentResult.getText(), "-");
        Assert.assertNotEquals(mainPage.commisionResult.getText(), "-");
        Assert.assertNotEquals(mainPage.firstInstallmentResult.getText(), "-");

        // click to see payment schedule
        mainPage.showPaymentSchedule.click();

        mainPage.paymentScheduleTable.shouldBe(Condition.visible);

        // click print payment schedule
        Helper.ClickWithNoWait(mainPage.paymentSchedulePrint);

        var wins = WebDriverRunner.driver().getWebDriver().getWindowHandles();

        Assert.assertNotEquals(wins.size(), 1);

        WebDriverRunner.driver().switchTo().window(wins.toArray()[1].toString());

        mainPage.printPopup.shouldBe(Condition.visible);
    }
}
