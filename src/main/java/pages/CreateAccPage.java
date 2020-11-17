package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreateAccPage extends BaseTest {

    public CreateAccPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Login']")
    WebElement LoginBtn;

    @FindBy(xpath = "//a[@href='/customer/account/create/']")
//    @FindBy(xpath = "//*[text()='CREATE AN ACCOUNT']")
    WebElement CreatAccount;

    @FindBy(id = "fi-firstName")
    WebElement FirstName;

    @FindBy(id = "fi-lastName")
    WebElement LastName;

    @FindBy(id = "fi-email")
    WebElement mail;

    @FindBy(id = "fi-password")
    WebElement password;

    @FindBy(id = "fi-phone")
    WebElement PhoneNumber;

    // fi-terms
    @FindBy(xpath = "//*[@for='fi-terms']")
    WebElement Terms;

    // fi-newsletter
    @FindBy(xpath = "//*[@for='fi-newsletter']")
    WebElement Newsletter;

    // Click on CreateAccPage button
    @FindBy(xpath = "//*[@class='btn _prim -fw']")
    WebElement CreateAccountbtn;


    public void CreateAccountMethod(String firstName, String lastName, String Mail, String Password, String phonenumber) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));
        LoginBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(CreatAccount));
	    CreatAccount.click();
        FirstName.clear();
        FirstName.sendKeys(firstName);
        LastName.clear();
        LastName.sendKeys(lastName);
        mail.clear();
        wait.until(ExpectedConditions.elementToBeClickable(mail));
        mail.sendKeys(Mail);
        password.clear();
        password.sendKeys(Password);
        PhoneNumber.clear();
        PhoneNumber.sendKeys(phonenumber);
        Terms.click();
        Newsletter.click();
        // ScrollIntoWebElement
        JavascriptExecutor js = ((JavascriptExecutor) BaseTest.driver);
        js.executeScript("arguments[0].scrollIntoView();", CreateAccountbtn);
        CreateAccountbtn.submit();
        driver.navigate().back();
//		} catch (Exception e) {
//
//			e.getMessage();
//		}
    }
    //		Using javascriptExcuter
    /*
     * String firstname = "Test";
     * JavascriptExecutor js = ((JavascriptExecutor)driver);
     * js.executeScript("arguments[0].setAttribute('value','"+firstname+"');", FirstName);
     */

}