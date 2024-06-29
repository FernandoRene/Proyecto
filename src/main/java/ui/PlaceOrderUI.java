package ui;

import org.openqa.selenium.By;

public class PlaceOrderUI {
    public static final By totalPriceInfo = By.id("totalp");
    public static final By productPriceItem = By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[3]");
    public static final By producTitleItem = By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[2]");

    public static final By PlaceOrderButton= By.xpath("//button[@class='btn btn-success' and contains(text(), 'Place Order')]");
}
