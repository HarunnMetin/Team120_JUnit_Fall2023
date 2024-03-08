package Day12_Cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

import static utilities.ReusableMethod.bekle;

public class C02_KlasikWebTable extends TestBase {

    @Test
    public void test01(){

        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        bekle(2);
        driver.navigate().refresh();

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(9);

        //3.Web table tum body’sini yazdirin
        WebElement tableBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tableBody.getText());
        bekle(7);

        //4.Web table’daki satir sayisinin 7 oldugunu test edin
        List<WebElement> listSatirListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi= 7;
        int actualSatirSayisi = listSatirListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5.Tum satirlari yazdirin
        for (int i = 0; i < listSatirListesi.size(); i++) {
            System.out.println((i+1)+". ci satir   : "+listSatirListesi.get(i).getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> birinciSSatirDataList = driver.findElements(By.xpath("//tr[1]/td"));
        int expectedDataSatirSayisi = 13;
        int actualDataSatirSayisi = birinciSSatirDataList.size();
        Assert.assertEquals(expectedDataSatirSayisi,actualDataSatirSayisi);
        //7. 5.sutunu yazdirin
        System.out.println("============ 5. sutun =============");
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//tr/td[5]"));
        for (int i = 0; i <besinciSutun.size() ; i++) {
            System.out.println((i+1)+". ci sutun  : "+ besinciSutun.get(i).getText());

        }
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi string olarak
        // döndüren bir method olusturun

        System.out.println("============= method ile gelen datalar =============");
        System.out.println(hucredekiBilgi(1, 1));
        System.out.println(hucredekiBilgi(5, 3));
    }


    public String hucredekiBilgi(int satirNo,int sutunNo){

        //  //tr[  5  ]/td[  4  ]

        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();

    }
}
