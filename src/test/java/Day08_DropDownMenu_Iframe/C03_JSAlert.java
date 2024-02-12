package Day08_DropDownMenu_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C03_JSAlert extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.youtube.com");
        bekle(3);
    }

    @Test
    public void jsAlertTesti(){
        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        //- 1.alert'e tiklayin
        WebElement  alert1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alert1.click();
        bekle(2);
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        bekle(2);
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }
    @Test
    public void alertCencelTesti(){

        //2.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(3);
        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        bekle(3);
        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id = 'result']"));
        String expectedCencel = "You clicked: Cancel";
        String actualCencel = sonucYazisi.getText();
        Assert.assertEquals(expectedCencel,actualCencel);
        bekle(3);

    }

    @Test
    public void promptTesti(){

        //3.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        bekle(2);
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        bekle(2);
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        bekle(2);
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedSonucText = "Abdullah";
        String actualSonucText = sonucYazisi.getText();
        Assert.assertTrue(actualSonucText.contains(expectedSonucText));
        bekle(2);
    }

}
