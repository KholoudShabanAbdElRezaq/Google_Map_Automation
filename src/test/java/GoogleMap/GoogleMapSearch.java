package GoogleMap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GoogleMapSearch {
    @Test(priority = 1)
    public static void openGoogleSearch()  {
        WebDriverManager.edgedriver().setup();
        WebDriver  webDriver= new EdgeDriver();
        webDriver.get("https://www.google.com/?hl=ar");
        webDriver.manage().window().maximize();
       webDriver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("GoogleMap");
    }
    @Test(priority = 2)
    public  static  void openGoogleMap () throws InterruptedException {
        WebDriver webDriver= new EdgeDriver();
        webDriver.navigate().to("https://www.google.com/maps/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("searchboxinput")).click();
        webDriver.findElement(By.id("searchboxinput")).clear();
        webDriver.findElement(By.id("searchboxinput")).sendKeys("Giza");
        webDriver.findElement(By.id("searchbox-searchbutton")).click();
        Thread.sleep(13000);
        webDriver.findElement(By.id("searchboxinput")).clear();
        webDriver.findElement(By.id("searchboxinput")).sendKeys("Alex");
        webDriver.findElement(By.id("searchbox-searchbutton")).click();
        TakesScreenshot scrShott =((TakesScreenshot)webDriver);
        File SrcFilee=scrShott.getScreenshotAs(OutputType.FILE);
        //  Files.move(scrShot , new File("resources/screenshot/test.png"));

        File DestFilee=new File("src/test/resources/screenshot/tessstalex.png");


        try {
            FileUtils.copyFile(SrcFilee, DestFilee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }



    @Test
    public static void main(String[] args)  throws InterruptedException  {
        openGoogleSearch();
        openGoogleMap();

    }
}
