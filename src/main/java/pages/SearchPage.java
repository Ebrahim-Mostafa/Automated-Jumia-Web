package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseTest {


	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "fi-q")
	WebElement input;

//	@FindBy(xpath = "//*[text()='Samsung Galaxy A70 - 6.7-inch 128GB/6GB Dual SIM 4G Mobile Phone - Black']")
//	WebElement Mobile;

	public void SearchforMobile(String ItemName, String ItemPrice) throws InterruptedException {
		try {
			input.click();
			input.clear();
			input.sendKeys(ItemName);
			input.submit();
			//	Mobile.click();
		}
		catch (Exception e){
			e.getMessage();
		}
	}
	// List<WebElement> list = input.findElements(By.tagName("p"));
	//name of the mobile
/*	List<WebElement> list = input.findElements(By.xpath("//p[class='p-name']"));
		for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).getText());
		if (list.get(i).getText().contains("Samsung Galaxy A70")) {
			System.out.println("We found it");
		}
		else {
			System.out.println("We never found it");
		}
	}*/

	//price of mobile
	/*List<WebElement> lst = input.findElements(By.xpath("//p[class='prc']"));//price of mobile
		for (int i = 0; i < lst.size(); i++) {
		System.out.println(lst.get(i).getText());
		if (lst.get(i).getText().contains("EGP 5,475")) {
			System.out.println("We found it");
		}
		else {
			System.out.println("We never found it");
		}*/
}


