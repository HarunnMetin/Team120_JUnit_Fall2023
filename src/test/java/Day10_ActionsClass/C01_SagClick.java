package Day10_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

import static utilities.ReusableMethod.bekle;

public class C01_SagClick extends TestBase {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        bekle(3);

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElement = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(ciziliAlanElement).perform();
        bekle(3);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        bekle(3);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        bekle(3);

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        String ikinciSayfaWindowHandleDegeri = "";
        Set<String> windowHandleSeti = driver.getWindowHandles();

        for (String each:windowHandleSeti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri = each;
            }
        }

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        String expectedYazi2 = "Make sure your code lands";
        String actualYazi2 = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYazi2,actualYazi2);

    }
}