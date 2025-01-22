package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek04_HandleWindows extends TestBaseEach {

    @Test
    public void test01(){
        /*
            ● testotomasyonu anasayfa adresine gidin.
            ● Sayfa’nin window handle degerini String bir degiskene atayin
            ● Sayfa title’nin “Otomasyon” icerdigini test edin
            ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
            ● Sayfa title’nin “wisequarter” icerdigini test edin
            ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
            ● Sayfa title’nin “Walmart” icerdigini test edin
            ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
         */

        //testotomasyonu anasayfa adresine gidin.
        driver.get("https://testotomasyonu.com/");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String testOtomasyonWhd = driver.getWindowHandle();

        //Sayfa title’nin “Otomasyon” icerdigini test edin

        String actualTestOtomasyonTitle = driver.getTitle();
        String expectedTestOtomasyonTitle = "Otomasyon";

        Assertions.assertTrue(actualTestOtomasyonTitle.contains(expectedTestOtomasyonTitle));
        ReusableMethods.bekle(3);

        //Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com.tr/");
        //driver.findElement(By.xpath("(//*[@aria-label='Close'])[1]")).click();
        ReusableMethods.bekle(3);

        //Sayfa title’nin “wisequarter” icerdigini test edin
        String expectedWiseTitle = "Wise Quarter";
        String actualWiseTitle = driver.getTitle();
        System.out.println(actualWiseTitle);

        Assertions.assertTrue(actualWiseTitle.contains(expectedWiseTitle));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");
        ReusableMethods.bekle(3);

        //Sayfa title’nin “Walmart” icerdigini test edin
        String expectedWalmartTitle = "Walmart";
        String actualWalmartTitle = driver.getTitle();

        Assertions.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));


        //Ilk acilan sayfaya donun ve testotomasyonu sayfasina dondugunuzu test edin
        driver.switchTo().window(testOtomasyonWhd);
        actualTestOtomasyonTitle = driver.getTitle();
        expectedTestOtomasyonTitle = "Otomasyon";

        Assertions.assertTrue(actualTestOtomasyonTitle.contains(expectedTestOtomasyonTitle));

        ReusableMethods.bekle(3);
    }
}
