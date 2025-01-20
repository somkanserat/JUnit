package calisma04_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_JsAlerts extends TestBaseEach {

    /*
    3 test method'u olusturup asagidaki gorevi tamamlayin
    1. Test
        -  https://testotomasyonu.com/javascriptAlert adresine gidin
        - 1.alert'e tiklayin
        -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        -  OK tusuna basip alert'i kapatin
    2.Test
        - https://testotomasyonu.com/javascriptAlert adresine gidin
        - 2.alert'e tiklayalim
        - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    3.Test
        - https://testotomasyonu.com/javascriptAlert adresine gidin
        - 3.alert'e tiklayalim
        - Cikan prompt ekranina "Abdullah" yazdiralim
        - OK tusuna basarak alert'i kapatalim
        - Cikan sonuc yazisinin Abdullah icerdigini test edelim
     */
    /*
        Bir webelement'e click yaptigimizda
        driver objesi ortam degisikligi beklemez

        ayni window'da kalip, farkli bir url'e gitmeyi bekler

        ANCAAKKKK bazi islemler yapildiginda
        farkli bir ortam olusabilir

        driver'i bu farkli ortama gecirmek icin
        driver.switchTo() kullanmamiz gerekir

        Bu durumlardan birisi JavaScript alert'lerdir.
        JsAlert calistiginda normal window uzerinde islem yapamayiz
        sag tus yapip locate alamadigimiz icin alert uzerinde driver'i calistiramayiz

        driver'in jsAlert'e gecmesi ve orada islem yapabilmesi icin
        oncelikle jsAlert evrenine switch yapmasi gerekir
     */

    @Test
    public void jsAlertsTest(){
        //1. Test
        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);

        //1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        //Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(actualAlertYazi, expectedAlertYazi);
        ReusableMethods.bekle(1);
        //OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmTest(){
        //2.Test
        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);

        //2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        //Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss(); //cancel' tıkladık
        ReusableMethods.bekle(1);

        String expectedResultYazi = "You clicked: Cancel";
        String actualResultYazi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        //elementi bulduk ve getText ile String olarak kaydettik
        Assertions.assertEquals(expectedResultYazi, actualResultYazi);
    }

    @Test
    public void jsPromptTest(){
        //3.Test
        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);

        //3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        //Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        ReusableMethods.bekle(1);

        //OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);

        //Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedResultYazi = "Abdullah";
        String actualResultYazi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        //elementi bulduk ve getText ile String olarak kaydettik
        Assertions.assertTrue(actualResultYazi.contains(expectedResultYazi));
    }
}
