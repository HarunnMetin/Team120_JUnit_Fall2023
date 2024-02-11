package Day08_DropDownMenu_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static utilities.ReusableMethod.bekle;

public class C01_DropDownMenu extends TestBase {

    @Test
    public void dropDownTesti(){

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownElementi = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownElementi);
        bekle(3);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);
        //4.Tüm dropdown değerleri(value) yazdırın
        System.out.println("*****Tum opsiyonlar*****");
        List<WebElement> optionsList = select.getOptions();
        for (WebElement each:optionsList) {
            System.out.println(each.getText());
        }
        bekle(3);
        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expecdetBoyut = 4;
        int actualBoyut = optionsList.size();

        Assert.assertEquals("Dropdown’UN boyutu 4 DEGİL test FAİLED",expecdetBoyut,actualBoyut);
    }
}
