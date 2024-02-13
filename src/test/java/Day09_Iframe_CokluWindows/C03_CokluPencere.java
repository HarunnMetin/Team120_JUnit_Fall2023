package Day09_Iframe_CokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C03_CokluPencere extends TestBase {

    @Test
    public void test01(){

        //amazon anasayfaya gidip url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        bekle(1);
        driver.navigate().refresh();
        String expectetUrl= "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectetUrl));
        String amazonWindowHandle = driver.getWindowHandle();
        bekle(2);
        //yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        expectetUrl ="wise";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectetUrl));
        String wiseWindowHandleDeger = driver.getWindowHandle();
        bekle(2);

        //yeni bir pencerede'da youtube'a gidin ve url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        expectetUrl ="youtube";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectetUrl));
        //wisequarterin acik oldugu sayfaya donup title'in Wise icerdigini test edin
        driver.switchTo().window(wiseWindowHandleDeger);
        String expectedIcerik = "Wise";
        String actualIcerik = driver.getTitle();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        bekle(2);
        //Amazon'un acik oldugu sayfaya donun ve title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonWindowHandle);
        expectedIcerik = "Amazon";
        actualIcerik = driver.getTitle();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        bekle(2);


    }

}
