package Day08_DropDownMenu_Iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforClass;

import java.util.List;

import static utilities.ReusableMethod.bekle;

public class C02_DropDownMenu extends TestBaseBeforClass {

    WebElement dropDownKategoriMenusu;
    Select select;
    @Before
    public void amazonaGidis(){
        // https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        dropDownKategoriMenusu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownKategoriMenusu);
    }
    @Test
    public void dropDownTesti(){

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        List<WebElement> kategoriList = select.getOptions();
        int expectedList = 45;
        int actualList = kategoriList.size();
        Assert.assertEquals("kategor menusunde 45 kategori yok test FAİLED",expectedList,actualList);
        //oldugunu test edin

    }
    @Test
    public void aramaTesti(){

        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java" , Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucText = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        System.out.println(sonucText.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedJavaKelimesi = "Java";
        String actualJavaKrlimesi = sonucText.getText();
        Assert.assertTrue(actualJavaKrlimesi.contains(expectedJavaKelimesi));
    }
}
