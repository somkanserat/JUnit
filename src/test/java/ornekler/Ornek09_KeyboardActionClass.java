package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class Ornek09_KeyboardActionClass extends TestBaseEach {
    /*
        1- https://html.com/tags/iframe/
           sayfasina gidelim
        2- video’yu gorecek kadar asagi inin
        3- videoyu izlemek icin Play tusuna basin
        4- videoyu calistirdiginizi test edin
     */

    @Test
    public void test01(){

        //1- Bir Class olusturalim KeyboardActions2
        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //3- videoyu izlemek icin Play tusuna basin
        List<WebElement> iframeListesi = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe listesi:" +iframeListesi.size());

        driver.switchTo().frame(iframeListesi.get(0));
        ReusableMethods.bekle(2);

        WebElement playTusu = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        playTusu.click();
        ReusableMethods.bekle(2);

        //4- videoyu calistirdiginizi test edin
        WebElement duraklatTusu = driver.findElement(By.xpath("//*[@data-title-no-tooltip='Duraklat']"));
        Assertions.assertTrue(duraklatTusu.isDisplayed());
        ReusableMethods.bekle(2);
    }
}
