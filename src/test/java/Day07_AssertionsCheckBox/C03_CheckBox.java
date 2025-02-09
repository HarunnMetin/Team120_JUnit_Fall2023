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

public class C03_CheckBox {



    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void checkBoxTest(){

        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.

        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type ='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type ='checkbox'])[2]"));
        ReusableMethod.bekle(2);
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        ReusableMethod.bekle(2);
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        ReusableMethod.bekle(2);
        //e. Checkbox1 ve Checkbox2’nin seçili olduğunu test edin

        Assert.assertTrue(checkBox1.isSelected() && checkBox2.isSelected());

    }
}
