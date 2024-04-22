package Day10_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C04_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        bekle(1);
        driver.navigate().refresh();
        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        bekle(1);
        //4- aramanin gerceklestigini test edin

        String expectedIcerik = "Samsung A71";
        String actualIcerik = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        bekle(3);
    }
}
