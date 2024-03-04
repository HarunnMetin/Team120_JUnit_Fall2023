package Day09_Iframe_CokluWindows;

import org.junit.Test;
import utilities.TestBase;

public class C04_KontrolsuzCokluWindow extends TestBase {

    @Test
    public void cokluPencereTesti(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        //● Click Here butonuna basın.
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
    }
}
