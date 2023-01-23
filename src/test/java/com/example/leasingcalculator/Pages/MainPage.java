package com.example.leasingcalculator.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public String pageUrl = "https://www.seb.lt/en/business/financing/leasing-your-business";

    public SelenideElement agreeToCookies = $(".seb-cookiemessage a.accept-selected");

    public SelenideElement calculatorFrame = $(".calculator-frame");
    public SelenideElement purchaseValue = $("[id='f-summa']");
    public SelenideElement purchaseValueError = $("[id='f-summa-error']");
    public SelenideElement interestRate = $("[id='f-likme']");
    public SelenideElement paymentTerm = $("[id='f-termins']");
    public SelenideElement firstInstallment = $("[id='f-maksa']");
    public SelenideElement firstInstallmentType = $("[id='f-maksa-type']");
    public SelenideElement remainingValue = $("[id='f-rest']");
    public SelenideElement calculate = $(".js-calculator-form [type='submit']");

    public SelenideElement monthlyPaymentResult = $(".js-results-info [data-name='monthly_payment']");
    public SelenideElement commisionResult = $(".js-results-info [data-name='commision']");
    public SelenideElement firstInstallmentResult = $(".js-results-info [data-name='maksa']");

    public SelenideElement addToComparison = $(".js-calculator-form .js-comparison-add");
    public SelenideElement showPaymentSchedule = $(".js-calculator-form .js-show-payment-schedule");
    public SelenideElement comparisonTable = $(".js-comparison-table table");
    public SelenideElement paymentSchedulePrint = $(".js-results-table .js-print");
    public SelenideElement paymentScheduleTable = $(".js-results-table table");
    public SelenideElement printPopup = $("print-preview-app");
}
