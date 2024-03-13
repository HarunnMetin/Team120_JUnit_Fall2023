package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethod {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaFotografiCek(WebDriver driver,String resimAdi){

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);
        String dinamikDosyaYolu = "target/Screenshot/"+resimAdi+tarihEtiketi+".jpg";

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File tumSayfaScreenShoot = new File(dinamikDosyaYolu);

        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenShoot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
