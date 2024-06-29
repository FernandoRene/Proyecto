package ui;

import org.openqa.selenium.By;

public class BillInformationUI {
    public static final By textname = By.xpath("//input[@type='text' and @class='form-control'][@id='name']");

    public static final By textcountry = By.xpath("//input[@type='text' and @class='form-control'][@id='country']");

    public static final By textcity= By.xpath("//input[@type='text' and @class='form-control'][@id='city']");


    public static final By textcreditcard = By.xpath("//input[@type='text' and @class='form-control'][@id='card']");

    public static final By textmonth = By.xpath("//input[@type='text' and @class='form-control'][@id='month']");

    public static final By textyear = By.id("year");

    public static final By buttonPurchase = By.xpath("//button[@class='btn btn-primary' and contains(text(), 'Purchase')]");
}
