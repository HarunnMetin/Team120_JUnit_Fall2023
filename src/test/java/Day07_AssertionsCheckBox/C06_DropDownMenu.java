package Day07_AssertionsCheckBox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static utilities.ReusableMethod.bekle;

public class C06_DropDownMenu extends TestBase {

    @Test
    public void test1(){

        driver.get("https://amazon.com");
        bekle(1);
        driver.navigate().refresh();

        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@*='Search in']"));
        Select select = new Select(dropDownMenu);
        select.selectByIndex(7);
        bekle(2);
        select.selectByValue("search-alias=baby-products-intl-ship");
        bekle(2);
        select.selectByVisibleText("Software");
        bekle(2);
    }


}
