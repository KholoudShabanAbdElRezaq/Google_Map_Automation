package visitbrowisng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.testng.AssertJUnit.assertEquals;

public class GetMethod {

    @Test
    public static  void openurl() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver= new ChromeDriver();
        webDriver.get("https://www.google.com/?hl=ar");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("facebook");
        // webDriver.findElement(By.xpath("//input[@name=\"btnK\"]")).sendKeys(Keys.RETURN);
        webDriver.navigate().to("https://www.facebook.com/");
        webDriver.findElement(By.id("email")).sendKeys("01223351410");
        webDriver.findElement(By.id("pass")).sendKeys("13579nada18");
        webDriver.findElement(By.xpath("//button[text()='Log in']")).click();
        // Assert.assertEquals("First Line\nSecond Line", "Third Line\nFourth Line");
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //  Files.move(scrShot , new File("resources/screenshot/test.png"));

        File DestFile=new File("src/test/resources/screenshot/tessst.png");


        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) throws IOException {


        openurl();



    }
}
