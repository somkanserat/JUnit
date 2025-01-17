package calisma02_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestNotasyonu {
    /*
        Test Notasyonu,  sıradan bir methodu, tek başına RUN edilebilir hale getirdi.

        @Test notasyonu sayesinde, her bir testi bağımsız olarak çalıştırabileceğim gibi,
        class isminin yanındaki RUN tuşu ile class'daki TUM test metot'larını toplu olarak da
        çalıştırabiliriz.

        JUnit @Test metotlarının belirlenmiş bir çalışma sırası yoktur. Sıralama öngörülemez ve kontrol edilemez.
        Sıralı çalıştırılmak istenirse, isimlerini, test01, test02,test03 diye bilirlemek gerekir.
     */

    @Test
    public void testOtomasyonuTest() {

        // Webdriver oluşturup, ayarları yapın.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");

        driver.quit();
    }

    @Test
    public void youtubeOtomasyonuTest() {

        // Webdriver oluşturup, ayarları yapın.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");

        driver.quit();
    }

    @Test
    public void wisequarterOtomasyonuTest() {

        // Webdriver oluşturup, ayarları yapın.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");

        driver.quit();
    }
}
