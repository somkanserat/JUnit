package ornekler;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek11_WindowHandle extends TestBaseEach {

    /*
        1."http://webdriveruniversity.com/" adresine gidin
        2."Login Portal" a  kadar asagi inin
        3."Login Portal" a tiklayin
        4.Diger window'a gecin
        5."username" ve  "password" kutularina deger yazdirin
        6."login" butonuna basin
        7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        8.Ok diyerek Popup'i kapatin
        9.Ilk sayfaya geri donun
        10.Ilk sayfaya donuldugunu test edin
     */

    @Test
    public void test01(){

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //3."Login Portal" a tiklayin
        WebElement loginPortalButonu = driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
        loginPortalButonu.click();

        //4.Diger window'a gecin
        /*
        ************* BU İŞLEMLERİ METOTLAŞTIRMIŞTIK *************
        String anaSayfaWindowHandle = driver.getWindowHandle();
        String loginPortalWindowHandle = "";
        Set<String> tumWindowHandleDegerleri = driver.getWindowHandles();

        for (String atamaYapilacakWh : tumWindowHandleDegerleri){

            if ( ! atamaYapilacakWh.equals(anaSayfaWindowHandle)){
                loginPortalWindowHandle = atamaYapilacakWh;
            }
        }
        driver.switchTo().window(loginPortalWindowHandle);
         */

        ReusableMethods.urlIleWindowDegistir(driver,"http://webdriveruniversity.com/Login-Portal/index.html");

        //5."username" ve  "password" kutularina deger yazdirin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(faker.internet().password());
        ReusableMethods.bekle(1);

        //6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        ReusableMethods.bekle(1);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedPopupYazisi = "validation failed";
        String actualPopunYazisi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedPopupYazisi,actualPopunYazisi);
        ReusableMethods.bekle(1);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.get("http://webdriveruniversity.com/");
        ReusableMethods.urlIleWindowDegistir(driver,"http://webdriveruniversity.com/");
        ReusableMethods.bekle(1);


        //10.Ilk sayfaya donuldugunu test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement contactUsButonu = driver.findElement(By.xpath("//*[text()='CONTACT US']"));
        Assertions.assertTrue(contactUsButonu.isDisplayed());
        //Assertions.assertTrue(loginPortalButonu.isDisplayed());
        ReusableMethods.bekle(2);

    }
}
