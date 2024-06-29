package tasks;

import actions.Enter;
import org.openqa.selenium.WebDriver;
import ui.BillInformationUI;

public class EnterBillInformation {


    public static void enterName(WebDriver driver, String name) {

        Enter.enterText(driver, BillInformationUI.textname, name);
    }

    public static void enterCountry(WebDriver driver, String country) {

        Enter.enterText(driver, BillInformationUI.textcountry, country);
    }

    public static void enterCity(WebDriver driver, String city) {

        Enter.enterText(driver, BillInformationUI.textcity, city);
    }

    public static void enterCreditCard(WebDriver driver, String credit) {

        Enter.enterText(driver, BillInformationUI.textcreditcard, credit);
    }
    public static void enterMonth(WebDriver driver, String month) {

        Enter.enterText(driver, BillInformationUI.textmonth, month);
    }
    public static void enterYear(WebDriver driver, String year) {

        Enter.enterText(driver, BillInformationUI.textyear, year);
    }
}
