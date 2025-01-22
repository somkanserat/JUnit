package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek13_Actions extends TestBaseEach {

    @Test
    public void test01(){

        //https://testotomasyonu.com/click sayfasına gidin.
        driver.get("https://testotomasyonu.com/click");

        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //double click ve don't release me yazılarının görünürlülüğünü kontrol ediniz.

        WebElement doubleClickYazisi = driver.findElement(By.xpath("//*[@id='btn1']"));
        WebElement releaseMeYazisi = driver.findElement(By.id("btn2"));

        Assertions.assertTrue(doubleClickYazisi.isDisplayed());
        Assertions.assertTrue(releaseMeYazisi.isDisplayed());
        ReusableMethods.bekle(1);

        //Double click' üzerine çift tıkla ve renginin değiştiğini kontrol et.
        actions.doubleClick(doubleClickYazisi).perform();
        ReusableMethods.bekle(1);

        WebElement basiliDoubleClick = driver.findElement(By.xpath("//*[@class='mystyle']"));
        Assertions.assertTrue(basiliDoubleClick.isDisplayed());
        ReusableMethods.bekle(1);

        //don't release me üzerine gel ve basılı tut. Well done yazısının görünür olduğunu kontrol ediniz.
        actions.clickAndHold(releaseMeYazisi).perform();
        ReusableMethods.bekle(3);

        WebElement WellDoneYazisi = driver.findElement(By.xpath("//*[text()='Well done!.....']"));
        Assertions.assertTrue(WellDoneYazisi.isDisplayed());

        ReusableMethods.bekle(3);

    }
}
