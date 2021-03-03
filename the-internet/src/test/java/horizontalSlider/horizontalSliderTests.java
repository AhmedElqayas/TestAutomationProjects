package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class horizontalSliderTests extends BaseTests {

    @Test
    public void testRightSliding(){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider("4");
        assertEquals(horizontalSliderPage.getRangeValue() , "4");
    }
}
