package Day11_FileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static utilities.ReusableMethod.bekle;

public class C01_FileDownload extends TestBase {

    @Test
    public void indirmeTesti(){

        //C:\Users\acer\Desktop

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(3);
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        bekle(3);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\acer\\Downloads\\logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
