package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

    DataFormatter formatter = new DataFormatter();      //      This will convert the data into string
    @Test(dataProvider="driveTest")
    public void testCaseData(String firstName, String lastName, String id)
    {
        System.out.println("First Name = " + firstName + " Last Name = " + lastName + " and ID is " + id);
    }

    @DataProvider(name="driveTest")
    public Object[][] getData() throws IOException
    {
        //      Get the path of the Excel File
        FileInputStream fis = new FileInputStream("C://Users//wafzal//Desktop//Test Data.xlsx");
        //      Create an Object of Excel File and pass the file path inside it
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //      Get the Sheet of index 0
        XSSFSheet sheet = workbook.getSheetAt(0);
        //      Get the count of Rows
        int rowsCount = sheet.getPhysicalNumberOfRows();
        //      Get the 1st Row
        XSSFRow row = sheet.getRow(0);
        //      Get the last column number
        int coulumCount = row.getLastCellNum();

        //      Create an Object of Multi-Dimensional Array
        Object dataSet[][] = new Object[rowsCount-1][coulumCount];

        for(int i=0; i<rowsCount-1; i++)
        {
            row = sheet.getRow(i+1);
            for(int j=0; j<coulumCount; j++)
            {
                XSSFCell cell = row.getCell(j);
                dataSet[i][j] = formatter.formatCellValue(cell);
            }
        }
        return dataSet;
        
        //Object [][] data = {{"Waqar", "Afzal", "371"}, {"Waqas", "Afzal", "372"}, {"Ammar", "Afzal", "373"}};
        //return data;
    }
}
