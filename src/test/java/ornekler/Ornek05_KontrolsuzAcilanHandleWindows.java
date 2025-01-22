package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class Ornek05_KontrolsuzAcilanHandleWindows extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1-https://testotomasyonu.com/addremove/adresine gidin.
            2-Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
            3-Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
            4-’Please click for Electronics Products’ linkine tiklayin.
            5-Electronics sayfasinin acildigini test edin
            6-Bulunan urun sayisinin 16 olduğunu test edin
            7-Ilk actiginiz addremove sayfasina donun
            8-Url’in addremove icerdigini test edin
         */

        //1-https://testotomasyonu.com/addremove/adresine gidin.
        driver.get("https://testotomasyonu.com/addremove");
        String testOtomasyonuWindowHandle = driver.getWindowHandle();
        ReusableMethods.bekle(2);

        //2-Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String expectedText = "Add/Remove Elements";
        String actualText = driver.findElement(By.tagName("h2")).getText();

        Assertions.assertEquals(actualText,expectedText);

        //3-Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedSayfaTitle = "Test Otomasyonu";
        String actualSayfaTitle = driver.getTitle();

        Assertions.assertEquals(actualSayfaTitle,expectedSayfaTitle);
        ReusableMethods.bekle(2);

        //4-’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();

        //5-Electronics sayfasinin acildigini test edin
        String electronicsWindowHandle = "";
        Set<String> tumWindowHandle = driver.getWindowHandles();

        for (String each : tumWindowHandle){
            if (! each.equals(testOtomasyonuWindowHandle)){
                electronicsWindowHandle=each;
            }
        }
        driver.switchTo().window(electronicsWindowHandle);
        ReusableMethods.bekle(2);

        String expectedUrunSayisiText = "16 Products Found";
        String actualUrunSayisiText = driver.findElement(By.xpath("//*[text()='16 Products Found']")).getText();

        Assertions.assertEquals(actualUrunSayisiText,expectedUrunSayisiText);
    }
}
