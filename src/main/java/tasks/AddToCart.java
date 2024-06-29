package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.DescriptionProductUI;

public class AddToCart {
    public static void AddButton(WebDriver driver){
        Click.on(driver, DescriptionProductUI.AddToCartButton);
    }
}

