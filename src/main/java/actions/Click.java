package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click {
    public static void on(WebDriver webDriver, By locator){

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();;
    }
}
