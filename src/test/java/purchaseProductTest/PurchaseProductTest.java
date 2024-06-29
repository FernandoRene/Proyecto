package purchaseProductTest;

import actions.AlertDom;
import actions.GetText;
import actions.IsDisplayed;
import com.aventstack.extentreports.Status;
import conf.BaseTest;
import helpers.JsonTestDataHelper;
import helpers.ScreenShotHelper;
import models.Client;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tasks.*;
import ui.DescriptionProductUI;
import ui.PlaceOrderUI;
import ui.PurchaseConfirmationUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class PurchaseProductTest extends BaseTest {
    public static String loginTestDataPath = "resources/testdata/placeOrder/";

    @Test(description = "Validar que los detalles del producto sean correctos en la pagina de la orden")
    public void validateDetailsProductTest() throws IOException, InterruptedException {
        String expectedProductName = "Sony vaio i7";

        SelectCategory.selectLaptop(driver);
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Categoria Laptos");
        SelectSpecificProduct.selectProduct(driver, expectedProductName);
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Producto Seleccionado");
        String expectedProductPrice = GetText.from(driver, DescriptionProductUI.productPriceItem);

        AddToCart.AddButton(driver);
        AlertDom.accept(driver);
        GoToCart.GoToCartButton(driver);
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Orden");

        String currentProductPrice = "$" + GetText.from(driver, PlaceOrderUI.productPriceItem) + " *includes tax";
        String currentProductName = GetText.from(driver, PlaceOrderUI.producTitleItem);

        Assert.assertEquals(currentProductName, expectedProductName);
        Assert.assertEquals(currentProductPrice, expectedProductPrice);
    }

    @Test(description = "Validar que una orden fue completada satisfactoriamente", dataProvider = "clientDataProvider")
    public void validateCompletePurchase(Client client) throws IOException, InterruptedException {
        String productName = "Sony vaio i7";

        SelectCategory.selectLaptop(driver);
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Categoria Laptos");
        SelectSpecificProduct.selectProduct(driver, productName);
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Producto Seleccionado");

        AddToCart.AddButton(driver);
        AlertDom.accept(driver);
        GoToCart.GoToCartButton(driver);
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Orden");

        PlaceOrders.PlaceOrderTask(driver);


        EnterBillInformation.enterName(driver, client.getName());
        EnterBillInformation.enterCountry(driver, client.getCountry());
        EnterBillInformation.enterCity(driver, client.getCity());
        EnterBillInformation.enterCreditCard(driver, client.getCredictCardNumber());
        EnterBillInformation.enterMonth(driver, client.getMonth());
        EnterBillInformation.enterYear(driver, client.getYear());
        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Datos del cliente");

        ClickOnPurchase.clickPurchase(driver);

        Assert.assertTrue(IsDisplayed.element(driver, PurchaseConfirmationUI.poupAlertConfirmation));

        Thread.sleep(2000);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Orden Completada");
        ClosePurchase.lastbutton(driver);

    }

    @DataProvider(name="clientDataProvider")
    public Object[] loginDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(loginTestDataPath + "clientData.json", Client.class);
    }


    @BeforeMethod
    @Override
    public void setUp(Method method) throws Exception {
        super.setUp( method);
    }
}
