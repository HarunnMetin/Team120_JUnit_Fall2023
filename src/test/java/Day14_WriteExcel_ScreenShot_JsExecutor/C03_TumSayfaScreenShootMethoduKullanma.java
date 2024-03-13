package Day14_WriteExcel_ScreenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C03_TumSayfaScreenShootMethoduKullanma extends TestBase {

    @Test
    public void testWise(){

        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        //url in wise icerdigini test edin
        String expectedUrl = "wise";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //sonucu raporlamak icin tum sayfa screenshoot alip kaydedin
        ReusableMethod.tumSayfaFotografiCek(driver,"wise");
    }

    @Test
    public void testAB(){

        //ahmetbulutluoz.com anasayfaya gidin
        driver.get("https://www.ahmetbulutluoz.com");
        //url in bulut icerdigini test edin
        String expectedUrl = "bulut";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //sonucu raporlamak icin tum sayfa screenshoot alip kaydedin
        ReusableMethod.tumSayfaFotografiCek(driver,"ahmetBulutluOz");
    }

    @Test
    public void testYoutube(){

        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        //url in youtube icerdigini test edin
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();
        //sonucu raporlamak icin tum sayfa screenshoot alip kaydedin
        ReusableMethod.tumSayfaFotografiCek(driver,"youtube");
    }

}
