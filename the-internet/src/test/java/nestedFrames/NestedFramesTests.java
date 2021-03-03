package nestedFrames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testNestedFrames(){

        var nestedFramesPage = homePage.clickFrames().clickNestedFrames();

//        String leftFrameText = nestedFramesPage.getLeftFrameText();
//        assertEquals(leftFrameText,"LEFT" , "incorrect frame text");

//        assertEquals(nestedFramesPage.getLeftFrameTextUsingWebElement(), "LEFT", "incorrect");

        assertEquals(nestedFramesPage.getLeftFrameTextUsingPosition(), "LEFT", "incorrect");

    }
}
