package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextClickTests extends BaseTests {

    @Test
    public void testRightCLick(){

        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        String actualAlertText = contextMenuPage.alert_getText();
        String expectedAlertText ="You selected a context menu";
        if(actualAlertText.equals(expectedAlertText)){
            contextMenuPage.alert_clickToAccept();
        }
        else{
            assertEquals(actualAlertText, expectedAlertText, "Incorrect alert text");
        }

    }
}
