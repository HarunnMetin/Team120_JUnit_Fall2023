package Day14_WriteExcel_ScreenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

import static utilities.ReusableMethod.bekle;

public class C02_GetScreenShotTumSayfa extends TestBase {

    @Test
    public void tumSayfaScreenshot() throws IOException {

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");
        bekle(1);
        driver.navigate().refresh();

        //nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonuclarin Nutella icerdigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedYazi = "Nutella";
        String actualYazi = sonucYaziElementi.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));

        //rapor icin sayfanin fotografini cekin
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File tumSyfaScreenshot = new File("target/Screenshot/tumSyfaScreenshot.png");
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSyfaScreenshot);

        bekle(3);




    }


}
