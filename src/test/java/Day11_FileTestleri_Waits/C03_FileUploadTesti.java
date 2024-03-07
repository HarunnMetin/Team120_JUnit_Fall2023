package Day11_FileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void fileUploadTesti(){

        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        bekle(1);
        //3. chooseFile butonuna basalim
        //4. text.txt dosyaini secelim.
        WebElement uploadButtonElementi = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.dir") +
                                           "/src/test/java/Day11_FileTestleri_Waits/text.txt";
        uploadButtonElementi.sendKeys(dinamikDosyaYolu);

        //5. Upload butonuna basalim.
        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();
        bekle(2);
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileeUploadTexti = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileeUploadTexti.isDisplayed());
        /*
        String expectedYazi = "File Uploaded!";
        String actuyalYazi = fileeUploadTexti.getText();
        Assert.assertTrue(actuyalYazi.contains(expectedYazi));
         */
        bekle(3);
    }
}
