package ui;

import org.openqa.selenium.By;

public class HomeUI {
    public static final By selectProduct = By.xpath("//a[contains(@class, 'list-group-item') and contains(text(), 'Laptops')]");
    public static final By productListLoaded= By.id("tbodyid");
    public static  By productItemToSearch(String namep){

        //return By.xpath("//a[@class='btn btn-success btn-lg' and contains(text(), '" + namep + "')]");
        return By.xpath("//a[contains(text(),'" + namep + "')]");
    }
}
