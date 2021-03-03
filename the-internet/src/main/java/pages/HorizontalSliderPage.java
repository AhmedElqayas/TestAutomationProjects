package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.tagName("input");
    private By rangeValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void moveSlider(String rangeValue){

        while(!getRangeValue().equals(rangeValue)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRangeValue(){
        return driver.findElement(rangeValue).getText();
    }

}
