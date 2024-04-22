package Day14_WriteExcel_ScreenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C05_YoutubeArama extends TestBase {

    @Test

    public void youtubeAramaTesti(){

        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        bekle(2);

        //ahmet bulutluoz icin arama yapin
        WebElement youtubeAramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
        youtubeAramaKutusu.sendKeys("ahmet bulutluoz" + Keys.ENTER);
        bekle(2);
        //bulunan videolardan ilkinin isminde Bulut gectigini test edin

        WebElement ilkVideo = driver.findElement(By.xpath("(//h3[@class='title-and-badge style-scope ytd-video-renderer'])[1]"));
        String expectedVideoYazisi = "Bulut";
        String actualVideoYazi = ilkVideo.getText();
        Assert.assertTrue(actualVideoYazi.contains(expectedVideoYazisi));
        bekle(3);

        //ilk videonun fotogrefini cekin



    }
}
