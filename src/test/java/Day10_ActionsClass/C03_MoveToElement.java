package Day10_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C03_MoveToElement extends TestBase {

    @Test

    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        bekle(1);
        driver.navigate().refresh();
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountListsElementi = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListsElementi).perform();
        bekle(2);
        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[@id=\"nav-al-wishlist\"]/a[1]/span")).click();
        bekle(2);
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedYazi = "Your Lists";
        String actualYazi = driver.findElement(By.xpath("//*[@id=\"my-lists-tab\"]/a/div")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        bekle(2);
    }
}
