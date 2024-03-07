package Day11_FileTestleri_Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_ExplicitlyWait {

    @Test
    public void test01(){

        //webDriver ayarlarini implicitlyWait olmadan yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3434));
        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[@id='message']"))));

        //WebElement itsGoneYazisi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));

        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.close();
    }
}
