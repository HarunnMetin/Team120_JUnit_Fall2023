package Day11_FileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma {

    @Test
    public void test01(){

        //masaustumuzde bulunan logo.png dosyasinin varligini
        //dinamik dosya yolu kullanarak test edelim

        //      C:\Users\acer       +       \Downloads\logo.png
        //     (ana dosya yolu)           (herkeste ayni olan kisim)

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\logo.png";
        System.out.println(dinamikDosyaYolu);

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        System.out.println(System.getProperty("user.dir"));

        //projemizde var olan text.txt ninvarligini dinamik dosya yolu ile test edelim


        //Day11_FileTestleri_Waits/text.txt

        String dinamikTextDosyaYolu = System.getProperty("user.dir") + "/src/test/java/Day11_FileTestleri_Waits/text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));


    }
}
