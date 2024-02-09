package Day06_NotationsAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    //3 test methodu olusturup assagidaki gorevleri bagimsiz
    //calisabilecek sekilde olusturun
    //1- Amazon anaysafaya gidin url nin amazon icerdigini test edin
    //2- Wisequarter sayfasina gidip titlenin wise icerdigini test edin sayfayi kapatin
    //3- youtube anasayfaya gidin titlenin best icermedigini test edin sayfayi kapatin

    WebDriver driver;
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void amazonTest(){

        //1- Amazon anaysafaya gidin url nin amazon icerdigini test edin

        setup();
        driver.get("https://www.amazon.com");

        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL amazon iceriyor PASSED");
        }
        else {
            System.out.println("URL amazon icermiyor FAILED");
        }
        ReusableMethod.bekle(2);
        driver.close();
    }
    @Test
    public void wiseTest(){

        //2- Wisequarter sayfasina gidip titlenin wise icerdigini test edin sayfayi kapatin

        setup();

        driver.get("https://wisequarter.com/");

        String expectedTitle = "wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("baslik wise iceriyor test PASSED");
        }
        else {
            System.out.println("baslik wise icermiyor test FAILED");
        }
        ReusableMethod.bekle(3);
        driver.close();
    }
    @Test
    public void youtubeTest(){

        //3- youtube anasayfaya gidin titlenin best icermedigini test edin sayfayi kapatin
        setup();
        driver.get("https://www.youtube.com");
        String expectedTitle = "best";
        String actualTitle = driver.getTitle();

        if (!actualTitle.contains(expectedTitle)){
            System.out.println("best baslikta var test PASSED");
        }
        else {
            System.out.println("best baslikta yok test FAILED");
        }
        ReusableMethod.bekle(2);
        driver.close();
    }
}
