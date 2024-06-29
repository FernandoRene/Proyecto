package ui;

import org.openqa.selenium.By;

public class DescriptionProductUI {
    public static final By AddToCartButton = By.xpath("//a[@class='btn btn-success btn-lg' and contains(text(), 'Add to cart')]");
    public static final By GotoCartButton =  By.id("cartur");
    public static final By productPriceItem = By.xpath("//h3[@class='price-container']");

}
