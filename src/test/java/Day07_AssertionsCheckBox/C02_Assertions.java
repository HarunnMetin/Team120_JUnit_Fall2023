package Day07_AssertionsCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C02_Assertions {

    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDown(){
        ReusableMethod.bekle(3);
        driver.close();
    }
    @Test
    public void titleTest(){

        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void imgTest(){

        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoImage = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/ytd-topbar-logo-renderer/a/div/ytd-logo/yt-icon/yt-icon-shape/icon-shape/div"));
        Assert.assertTrue(logoImage.isDisplayed());
    }
    @Test
    public void searchBoxTest(){

        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//div[@id=\"search-input\"]"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){

        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }


}
