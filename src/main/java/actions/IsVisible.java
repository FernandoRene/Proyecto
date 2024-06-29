package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsVisible {
    public static void accept(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Cambiado de 5 a 10 segundos
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
