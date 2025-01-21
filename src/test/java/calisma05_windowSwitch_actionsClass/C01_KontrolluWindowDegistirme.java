package calisma05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_KontrolluWindowDegistirme extends TestBaseEach {


    @Test
    public void test01(){

        /*
            Eger bize verilen gorevde
            yeni bir Tab veya yeni bir Window acilmasi isteniyorsa
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.WINDOW);
            ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak gecirebiliriz

            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            hedef window'un WindowHandle degerini girmeliyiz
            driver.switchTo().window(wisequarterWhd);

            Eger birden fazla window aciyorsak ve geri donmemiz gerekecekse
            acilan her window'un window handle degerini kaydetmek
            faydali olacaktir.
         */

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // whd'ini kaydedin ve yazdirin
        String testOtomasyonuWhd = driver.getWindowHandle();
        System.out.println("Test Otomasyonu Window Handle:"+testOtomasyonuWhd);
        ReusableMethods.bekle(2);

        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        ReusableMethods.bekle(2);

        // whd'ini kaydedin ve yazdirin
        String wiseWindowHandle = driver.getWindowHandle();
        System.out.println("Wisequarter Window Handle:"+wiseWindowHandle);
        ReusableMethods.bekle(2);

        // yeni bir window acarak, arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");
        ReusableMethods.bekle(2);

        // whd'ini kaydedin ve yazdirin
        String arabamWindowHandle = driver.getWindowHandle();
        System.out.println("Arabam.com Window Handle:"+arabamWindowHandle);
        ReusableMethods.bekle(2);

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin
        driver.switchTo().window(wiseWindowHandle);
        String actualWiseUrl = driver.getCurrentUrl();
        String expectedWiseUrl = "wisequarter";

        Assertions.assertTrue(actualWiseUrl.contains(expectedWiseUrl));
        ReusableMethods.bekle(2);

        // testotomasyonu'nun acik oldugu window'a donun
        // ve url'in testotomasyonu icerdigini test edin

        driver.switchTo().window(testOtomasyonuWhd);

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);



    }
}
