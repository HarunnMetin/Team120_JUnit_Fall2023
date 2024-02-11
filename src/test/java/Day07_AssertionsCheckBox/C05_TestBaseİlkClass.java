package Day07_AssertionsCheckBox;

import org.junit.Test;
import utilities.ReusableMethod;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C05_TestBaseİlkClass extends TestBase {

    @Test
    public void testBase(){

        driver.get("https://amazon.com");
        bekle(3);

    }
}
