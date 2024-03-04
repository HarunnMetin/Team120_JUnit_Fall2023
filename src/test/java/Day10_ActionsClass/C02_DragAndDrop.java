package Day10_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C02_DragAndDrop extends TestBase {

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        bekle(3);
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement suruklenecekButon = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement suruklenecekHedefAlan = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(suruklenecekButon,suruklenecekHedefAlan).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi = "Dropped!";
        String actualYazi = driver.findElement(By.xpath("//p[text()= 'Dropped!']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        bekle(3);



    }
}
