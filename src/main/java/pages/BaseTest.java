package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement popupclose;


    @BeforeTest
    @Parameters({"Browser"})
    public void Setup(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--incognito");
            //option.addArguments("--start-fullscreen");
            option.addArguments("--start-maximized");
            //option.setHeadless(true);
            //option.addArguments("--headless");
            driver = new ChromeDriver(option);
        } else if (browser.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            //fire option = new ChromeOptions();
            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--incognito");
            // option.addArguments("--start-fullscreen");
            option.addArguments("--start-maximized");
            //option.setHeadless(true);
            driver = new FirefoxDriver(option);

        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            ieCapabilities.setCapability("ignoreZoomSetting", true);
            ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
            driver = new InternetExplorerDriver(ieCapabilities);
            driver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("EdgeDriver")) {
            EdgeDriverService service = EdgeDriverService.createDefaultService();
            WebDriverManager.edgedriver().getVersions();
            WebDriverManager.edgedriver().getBinaryPath();
            WebDriverManager.edgedriver().getDownloadedVersion();
            WebDriverManager.edgedriver().clearPreferences();
            WebDriverManager.edgedriver().clearCache();
            WebDriverManager.edgedriver().forceDownload().setup();
            //	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(service);
            driver.manage().window().maximize();


        } else if (browser.equalsIgnoreCase("Opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

        try {
            driver.get("https://www.jumia.com.eg/");
            popupclose = driver.findElement(By.xpath("//button[@data-track-onclick='popupClose']"));
            boolean bool = popupclose.isDisplayed();
            boolean booll = popupclose.isEnabled();

            if (bool == true && booll == true) {

                popupclose.click();
            } else {

                System.out.println("There is no pop up present");

            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

//if(WrapsElement.class.CreateAccPage(element.getClass()))
//
//    {
//        driver = ((WrapsDriver) ((WrapsElement)element).getWrappedElement()).getWrappedDriver();
//    }
//else
//
//    {
//        driver = ((WrapsDriver) element).getWrappedDriver();
//    }

    @BeforeMethod
    public void projectwaits() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    @AfterMethod
    public void TakeScreenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot TS = (TakesScreenshot) driver;
            File Source = TS.getScreenshotAs(OutputType.FILE);
            String FilePath = System.getProperty("user.dir") + "\\Automated-jumia-Web\\ScreenShots\\";
            FileUtils.copyFile(Source, new File(FilePath + result.getName() + ".jpg"));
        }

    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}
