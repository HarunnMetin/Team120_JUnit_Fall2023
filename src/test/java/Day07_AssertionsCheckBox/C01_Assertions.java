package Day07_AssertionsCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import java.time.Duration;

public class C01_Assertions {

    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //asagidaki testleri yapin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new  ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        ReusableMethod.bekle(3);
        driver.close();

    }

    @Test
    public void urlTest(){

        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void titleTest(){

        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void logoTest(){

        //○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void fransizcaLinkTest(){

        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLink = driver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/button"));
        Assert.assertTrue(fransizcaLink.isDisplayed());

    }


}