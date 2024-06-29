package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.BillInformationUI;

public class ClickOnPurchase {
    public static void clickPurchase(WebDriver driver) {
        Click.on(driver, BillInformationUI.buttonPurchase);
    }
}
