package Day12_Cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

import static utilities.ReusableMethod.bekle;

public class C01_Cookies extends TestBase {

    @Test
    public void cookiesTesti(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        bekle(2);
        driver.navigate().refresh();

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet);

        int siraNo = 1;

        for (Cookie each:cookieSet) {
            System.out.println(siraNo+" - "+each);
            siraNo++;
        }


        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCookieSayisi = 5;
        int actualCookieSayisi = cookieSet.size();
        Assert.assertTrue(actualCookieSayisi>expectedMinCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedYazi = "USD";
        String actualYazi = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedYazi,actualYazi);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        System.out.println("============= yeni cookie eklendikten sonra ===============");
        siraNo = 1;

        cookieSet = driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(siraNo+" - "+each);
            siraNo++;
        }

        boolean yeniCookieEklendimi = false;

        for (Cookie each:cookieSet) {
            if (each.getName().equals("en sevdigim cookie")){
                yeniCookieEklendimi = true;
            }
        }
        Assert.assertTrue(yeniCookieEklendimi);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        System.out.println("============= skin silindikten sonra ===============");
        siraNo = 1;

        cookieSet = driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(siraNo+" - "+each);
            siraNo++;
        }

        boolean skinSilindiMi = true;

        for (Cookie each: cookieSet) {
            if (each.equals("skin")){
                skinSilindiMi = false;
            }
        }
        Assert.assertTrue(skinSilindiMi);

        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        System.out.println("============= tum cookie'ler silindikten sonra ===============");
        siraNo = 1;

        cookieSet = driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(siraNo+" - "+each);
            siraNo++;
        }

        bekle(4);

        int expectedCookieSize = 0;
        int actualCookieSize = cookieSet.size();
        Assert.assertEquals(expectedCookieSize,actualCookieSize);
    }
}
