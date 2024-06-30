package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.HomeUI;

public class SelectCategory {
    public static void selectLaptop(WebDriver driver){
        Click.on(driver, HomeUI.selectProduct);
    }
}
