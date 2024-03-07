package Day11_FileTestleri_Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitlyWait {

    @Test
    public void test01() throws InterruptedException {

        //WebDriver ayarlarini implicitlyWait kullanmadan yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse("erisilebilir",textBoxElementi.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton = driver.findElement(By.xpath("//*[text()='Enable']"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enabledYazisi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(enabledYazisi.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBoxElementi.isEnabled());

        Thread.sleep(3);
        driver.close();
    }
}
