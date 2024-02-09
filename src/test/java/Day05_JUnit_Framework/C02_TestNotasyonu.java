package Day05_JUnit_Framework;


import org.junit.Ignore;
import org.junit.Test;

public class C02_TestNotasyonu {
    @Test
    public void amazonTest01(){
        System.out.println("amazon test calisti");

    }
    @Test @Ignore
    public void youtubeTest02(){
        System.out.println("youtube test calisti");

    }
    @Test
    public void wiseTest(){
        System.out.println("wise test calisti");

    }
    @Test
    public void test04(){
        //verilen iki sayidan sayi birin daha buyuk oldugunu test edin

        int sayi1 = 10;
        int sayi2 = 50;

        if (sayi1>sayi2){
            System.out.println("karsilatirma testi PASSED");
        }
        else {
            System.out.println("karsilastirma testi FAİLED");
            throw new RuntimeException();
        }




    }
}
