package pages;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader extends BaseTest {
    //private static XSSFWorkbook workbook;
    // private static XSSFSheet sheet;
    public static Object[][] getDataFromExcel(String Sheetname) throws IOException {
        //  Object[][] data=null;
        File file = new File(System.getProperty("user.dir")+
                "\\Data\\UserData.xlsx");
        FileInputStream FIS = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(FIS);
        Sheet   sheet =  workbook.getSheet(Sheetname);
        int rows = sheet.getPhysicalNumberOfRows();
     //     int rows = sheet.getLastRowNum()+1;
        int columns=sheet.getRow(0).getPhysicalNumberOfCells();
      //  int columns=sheet.getRow(0).getLastCellNum();
        Object data[][]= new Object[rows-1][columns];
        for(int i=1;i<rows;i++)
        {
            for (int j=0;j<columns;j++) {

                data[i-1][j] = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                //  data[i-1][j] = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
            }
        }
        workbook.close();
        return  data;
    }
}
