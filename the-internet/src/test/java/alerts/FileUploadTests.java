package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("D:\\Workspace\\IntelliJ\\Selenium\\the-internet\\resources\\chromedriver.exe");
        assertEquals(fileUploadPage.getUploadedFiles(), "chromdriver.exe", "Incorrect uploaded files");
    }
}
