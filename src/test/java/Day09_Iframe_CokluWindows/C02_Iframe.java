package Day09_Iframe_CokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static utilities.ReusableMethod.bekle;

public class C02_Iframe extends TestBase {

    @Test
    public void test01(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        bekle(2);
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi : " + iframeSayisi.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeIframe = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        bekle(3);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        bekle(3);
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement jmeterIframe = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(jmeterIframe);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }
}
