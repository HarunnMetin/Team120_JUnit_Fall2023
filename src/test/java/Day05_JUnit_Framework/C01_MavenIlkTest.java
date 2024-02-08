package Day05_JUnit_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        ReusableMethod.bekle(2);

        //2- arama kutusunu locate edelim
        driver.navigate().refresh();
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonuc = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        System.out.println("Bulunan sonuclar : "+sonuc.getText());
        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[1]/div/div/div/div[2]/div/a")).sendKeys(Keys.ENTER);


        //6- Onceki sayfaya donup, sayfadaki tum basliklari yazdiralim

        driver.navigate().back();
        List<WebElement> tumBasliklar = driver.findElements(By.xpath("//a[@class ='a-link-normal s-navigation-item']"));

        int sira = 0;
        for (int i = 0; i < tumBasliklar.size(); i++) {

            sira++;
            System.out.println(sira +"- "+tumBasliklar.get(i).getText());
        }
        ReusableMethod.bekle(5);
        driver.close();

    }
}
