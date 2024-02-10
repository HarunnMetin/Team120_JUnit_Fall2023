package Day06_NotationsAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    //amazon anasayfaya gidin 3 farkli test methodu olusturarak asagidaki gorevleri yapin
    //1- title nin Amazon icerdigini test edin
    //2- arama kutusuna "nutella" yazip aratin ve sonuzun nutella icerdigini test edin
    //2- arama kutusuna "Java" yazip aratin ve sonuzun Java icerdigini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
        ReusableMethod.bekle(2);
        driver.navigate().refresh();
    }
    @AfterClass
    public static void tearDown(){
        ReusableMethod.bekle(3);
        driver.close();
    }
    @Test
    public void titleTest(){

        //1- title nin Amazon icerdigini test edin
        String expectedIcerik = "Amazon";
        String actualIcerik = driver.getTitle();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        /*
        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("title testi PASSED");
        }
        else {
            System.out.println("title testi FAILED");
        }

         */

    }
    @Test
    public void nutellaTest(){

        //2- arama kutusuna "nutella" yazip aratin ve sonucun nutella icerdigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+Keys.ENTER);

        WebElement sonucYaziElemnti = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div"));
        String expectedIcerik = "nutella";
        String actualIcerik = sonucYaziElemnti.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        /*
        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("icerik testi PASSED");
        }
        else {
            System.out.println("icerik testi FAILED");
        }

         */

    }
    @Test
    public void javaTest(){

        //2- arama kutusuna "Java" yazip aratin ve sonuzun Java icerdigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div"));
        String expectedSonucYazisi = "Java";
        String actualSonucYazisi = sonucYazisi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

        /*
        if (actualSonucYazisi.contains(expectedSonucYazisi)){
            System.out.println("sonuc Java iceriyor PASSED");
        }
        else {
            System.out.println("sonuc Java icermiyor FAILED");
        }

         */

    }

}
