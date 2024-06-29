package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.DescriptionProductUI;

public class GoToCart {
    public static void GoToCartButton(WebDriver driver) {
        Click.on(driver, DescriptionProductUI.GotoCartButton);
    }
}
