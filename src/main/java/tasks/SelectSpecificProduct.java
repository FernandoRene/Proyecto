package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.HomeUI;

public class SelectSpecificProduct {
    public static void selectProduct(WebDriver driver, String namep){

        Click.on(driver, HomeUI.productItemToSearch(namep));
    }
}
