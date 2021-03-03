package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class UserRegistrationWithDDTAndExcel {

    @DataProvider(name="ExcelData")
    public Object[][] userData() throws IOException {

        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData();
    }
}
