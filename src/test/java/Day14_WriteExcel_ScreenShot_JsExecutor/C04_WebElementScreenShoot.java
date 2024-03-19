package Day14_WriteExcel_ScreenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_WebElementScreenShoot extends TestBase {

    @Test

    public void test01() throws IOException {

        //amazona gidelim
        driver.get("https://www.amazon.com");

        //nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonuclarin nutella icerdigini testedelim
        WebElement sonucTexti = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div"));
        String expectedSonucYazisi = "Nutella";
        String actualSonucYazisi = sonucTexti.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

        //rapora eklemek icinsonuc yazisinin screenshot'ini alalim

        File screenShoot = new File("target/Screenshot/sonucYazisi.jpg");
        File geciciResim = sonucTexti.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShoot);

        ReusableMethod.webelementFotografiCek(sonucTexti,"nutellaWebElementi");

    }
}
