package Login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.CreateAccPage;
import pages.ExcelReader;

import java.io.IOException;

public class CreatAccTest extends BaseTest {
    private static CreateAccPage acc ;
//    private static String Expec ;
    public static String Expect ;

    @DataProvider(name = "ExcelData")
    public  Object[][] testdata() throws IOException {
        Object data[][] = ExcelReader.getDataFromExcel("CreatAccData");
        return data;
//        ExcelReader ER = new ExcelReader();
//        return ER.getDataFromExcel("CreatAccData");
//        return ExcelReader.getDataFromExcel("CreatAccData");
    }

    @Test(dataProvider = "ExcelData")
    public void UserCanCreateAcc(String firstName,String lastName,String Mail,String Password,String phonenumber) throws InterruptedException {
        acc=new CreateAccPage(driver);
        acc.CreateAccountMethod( firstName,lastName, Mail,Password,phonenumber);
        Expect="Ebrahim";
        Assert.assertEquals(firstName,Expect,"Still coding ? ");
    }
}