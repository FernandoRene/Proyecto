package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.PurchaseConfirmationUI;
public class ClosePurchase {
    public static void lastbutton(WebDriver driver) {
        // Esperar a que el cuadro de diálogo de alerta esté presente
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(PurchaseConfirmationUI.poupAlertConfirmation));
        // Hacer clic en el botón de cierre de compra
        Click.on(driver, PurchaseConfirmationUI.ClosePurchase);
    }
}
