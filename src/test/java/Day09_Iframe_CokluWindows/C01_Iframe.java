package Day09_Iframe_CokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C01_Iframe extends TestBase {

    @Test
    public void test01(){

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement anIframeText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(anIframeText.isEnabled());
        bekle(3);
        //- Text Box’a “Merhaba Dunya!” yazin.

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");
        bekle(2);
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalLinki = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalLinki.isDisplayed());
        System.out.println(elementalLinki.getText());

    }
}
