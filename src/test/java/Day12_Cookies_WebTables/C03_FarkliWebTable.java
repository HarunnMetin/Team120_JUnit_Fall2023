package Day12_Cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static utilities.ReusableMethod.bekle;

public class C03_FarkliWebTable extends TestBase {

    @Test
    public void webTablesTest(){

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//*[@role='columnheader']"));
        int sira =0;
        for (WebElement each:basliklarListesi) {
            System.out.println(sira +" - " + each.getText());
            sira++;
        }
        bekle(4);

        //3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : "+basliklarListesi.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//*[@*='rt-table']"));
        System.out.println("Tum body datalari : "+tumBodyElementi.getText());

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> tumDatalarListesi = driver.findElements(By.xpath("((//*[@role='rowgroup'])//*[@role='gridcell'])"));
        int sayac = 0;
        for (WebElement each : tumDatalarListesi) {

            if (!each.getText().isBlank()){
                sayac++;
                System.out.println(sayac + " - "+each.getText());
            }

        }

        System.out.println("bos olmayan datasayisi : "+sayac);

        //6. Tablodaki satir sayisini yazdirin
        //7. Tablodaki sutun sayisini yazdirin
        //8. Tablodaki 3.kolonu yazdirin
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin
    }
}
