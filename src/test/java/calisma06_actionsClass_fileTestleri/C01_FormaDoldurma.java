package calisma06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_FormaDoldurma extends TestBaseEach {
    private static final Logger log = LoggerFactory.getLogger(C01_FormaDoldurma.class);

    /*
        1- https://www.testotomasyonu.com adresine gidelim
        2- Account linkine tiklayin
        3- Sign Up linkine basalim
        4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        5- Kaydin olusturuldugunu test edin
     */
    /*
        Daha önce, form kutularını WebElement olarak kaydedip, yazma işlemi yapıyorduk.
        Daha pratik yöntem; Firstname kutusuna click yapıp,isim gönderelim. Sonraki kutulara
        geçişi TAB tuşu ile yapalım.
     */

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='cart-bar'])[1]")).click();
        ReusableMethods.bekle(2);

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
        ReusableMethods.bekle(2);

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));

        Actions actions = new Actions(driver);

        actions.click(firstnameKutusu)
                .sendKeys("Harry")
                .sendKeys(Keys.TAB)
                .sendKeys("Potter")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys("serat@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        driver.findElement(By.xpath("//*[@id='btn-submit-form']")).click();
        ReusableMethods.bekle(2);

        //5- Kaydin olusturuldugunu test edin

            // Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
            // kaydin olustugunu test edebilmek icin
            // giris yapalim

        WebElement emailKutusu = driver.findElement(By.xpath("//*[@id='email']"));
        actions.sendKeys(emailKutusu)
                .sendKeys("serat@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        driver.findElement(By.xpath("//*[@id='submitlogin']")).click();
        ReusableMethods.bekle(2);

        //giriş yaptıktan sonra çıkan sayfadaki logout butonunun erişilebilir olduğunu test edelim

        WebElement logoutButonu = driver.findElement(By.xpath("(//*[@class='img-round mx-2'])[6]"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();
        ReusableMethods.bekle(2);
    }
}
