package ui;

import org.openqa.selenium.By;

public class PurchaseConfirmationUI {

    public static final By poupAlertConfirmation = By.xpath("//div[contains(@class, 'sweet-alert') and contains(@class, 'showSweetAlert') and contains(@class, 'visible')]");
    public static final By ClosePurchase = By.xpath("//button[text()='OK']");
}
