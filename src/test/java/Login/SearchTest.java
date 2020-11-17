package Login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.ExcelReader;
import pages.SearchPage;

import java.io.IOException;

public class SearchTest extends BaseTest {
    public static SearchPage SP;
    private static String Expected ;
    private static String Expectedd ;

    @DataProvider(name = "ExcelData")
    public  Object[][] testdata() throws IOException {
        Object data[][] = ExcelReader.getDataFromExcel("SearchData");
        return data;
//        ExcelReader ER = new ExcelReader();
//        return ER.getDataFromExcel("TestData");
//        return ExcelReader.getDataFromExcel("TestData");

    }

    @Test(dataProvider = "ExcelData")
    public void UserCanSearch(String ItemName,String ItemPrice) throws InterruptedException {
        SP = new SearchPage(driver);
        SP.SearchforMobile(ItemName,ItemPrice);
        Expected = "Samsung Galaxy A70 - 6.7-inch 128GB/6GB Dual SIM 4G Mobile Phone - Black";
        Assert.assertEquals(ItemName,Expected, "Go Fuck yourself if false");
        Expectedd = "5000";
        Assert.assertEquals(ItemPrice,Expectedd,"Don't continue stay manual");
    }
}
