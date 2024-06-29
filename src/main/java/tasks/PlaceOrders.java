package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.PlaceOrderUI;

public class PlaceOrders {
    public static void PlaceOrderTask(WebDriver driver){
        Click.on(driver, PlaceOrderUI.PlaceOrderButton);
    }
}
