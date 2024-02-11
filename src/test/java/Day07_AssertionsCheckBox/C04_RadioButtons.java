package Day07_AssertionsCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import java.time.Duration;
import java.util.List;

public class C04_RadioButtons {



    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){
        ReusableMethod.bekle(3);
        driver.close();
    }

    @Test
    public void radioButtonTest(){

        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");
        //b. Cookies’i kabul edin
        //c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();

        //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement  femaleRadio = driver.findElement(By.xpath("(//*[@*='_58mt'])[1]"));
        WebElement  maleRadio = driver.findElement(By.xpath("(//*[@*='_58mt'])[2]"));
        WebElement  costumRadio = driver.findElement(By.xpath("(//*[@*='_58mt'])[3]"));
        maleRadio.click();
        ReusableMethod.bekle(3);
        //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(!femaleRadio.isSelected() && maleRadio.isSelected() && !costumRadio.isSelected());

    }

}
