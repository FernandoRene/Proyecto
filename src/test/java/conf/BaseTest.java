package conf;

import actions.AlertDom;
import com.aventstack.extentreports.Status;
import helpers.ReportManager;
import helpers.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tasks.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private String url = "https://www.demoblaze.com/";


    @BeforeSuite
    public static void setupSuite () throws Exception {
        ReportManager.init("Reports", "PurchaseSuite");
    }

    @BeforeMethod
    @Parameters({"url", "browser"})
    public void setUp (Method method) throws Exception {
        //public void setUp (String url, String browser) throws Exception {
        //public void setUp (ITestResult iTestResult) throws Exception {
        String url = "https://www.demoblaze.com/";
        String browser = "chrome";
        //public void setUp (ITestResult iTestResult, String url, String browser) throws Exception {
        //ReportManager.getInstance().startTest(iTestResult.getMethod().getDescription());
        ReportManager.getInstance().startTest(method.getName());
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception(browser + "no soportado");
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        SelectCategory.selectLaptop(driver);

        SelectSpecificProduct.selectProduct(driver, "Sony vaio i7");

        AddToCart.AddButton(driver);
        AlertDom.accept(driver);
        GoToCart.GoToCartButton(driver);
        PlaceOrders.PlaceOrderTask(driver);

        EnterBillInformation.enterName(driver, "Maria");
        EnterBillInformation.enterCountry(driver, "Moreira");
        EnterBillInformation.enterCity(driver, "Cochambamba");
        EnterBillInformation.enterCreditCard(driver, "525312d3712231");
        EnterBillInformation.enterMonth(driver, "Junio");
        EnterBillInformation.enterYear(driver, "2009");

        ClickOnPurchase.clickPurchase(driver);

        ClosePurchase.lastbutton(driver);
    }

    @AfterMethod
    public void tearDown (ITestResult iTestResult){
        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failes");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passes");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if (iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "Failure Image");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null)
                driver.quit();
            //log.info("Closing the driver");
        }
    }

    @AfterSuite
    public static void tearDownSuite () {
        ReportManager.getInstance().flush();
    }
}
