package ornekler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class Ornek01_BestBuyAssertions_isDisplayed {

    /*

        1) Bir class oluşturun
        2) https://www.bestbuy.com/
        asagidaki testleri yapin
        Adresine gidin farkli test method’lari olusturarak
            ○ Sayfa URL’inin https://www.bestbuy.com/
              ‘a esit oldugunu test edin
            ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
            ○ logoTest => BestBuy logosunun görüntülendigini test edin
            ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

     */


    static WebDriver driver;
    @BeforeAll
    static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://www.bestbuy.com/");

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        ReusableMethods.bekle(2);

        Assertions.assertEquals(actualUrl, expectedUrl, "Sayfa Url'si, beklenen Url'e eşit değil.");
    }

    @Test
    public void test02(){
        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        ReusableMethods.bekle(2);

        Assertions.assertFalse(actualTitle.contains(expectedTitle), "Sayfa başlığı 'Rest' içermektedir.");
    }

    @Test
    public void test03(){
        WebElement sayfaLogo = driver.findElement(By.xpath("//*[@src='logo'][1]"));

        Assertions.assertTrue(sayfaLogo.isDisplayed(),"Logo Bulunamadı.");
        ReusableMethods.bekle(2);
    }
    @Test
    public void test04(){
        WebElement francaLink = driver.findElement(By.xpath("//*[@lang='fr'][1]"));

        Assertions.assertTrue(francaLink.isDisplayed(),"Link Bulunamadı.");
        ReusableMethods.bekle(1);
    }
}
