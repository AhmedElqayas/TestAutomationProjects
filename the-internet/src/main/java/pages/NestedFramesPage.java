package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {

    private WebDriver driver;


    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }


    public String getLeftFrameTextUsingName(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;

    }


    public String getLeftFrameTextUsingWebElement(){
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        String text = driver.findElement(By.tagName("body")).getText();


        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        return text;

    }

    public String getLeftFrameTextUsingPosition(){
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        String text = driver.findElement(By.tagName("body")).getText();


        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        return text;

    }




}
