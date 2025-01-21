package calisma06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_FormDoldurma extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim

        /*
            Formdaki tum kutulari tek tek locate etmek yerine
            firstName kutusuna click yapip, isim gonderelim
            sonraki kutulara gecisi de TAB tusu ile yapabiliriz
         */

        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(firstNameKutusu)
                .sendKeys("Serat")
                .sendKeys(Keys.TAB)
                .sendKeys("Somkan")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys("serat@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        //   ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();


        //5- Kaydin olusturuldugunu test edin

        // Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
        // kaydin olustugunu test edebilmek icin
        // giris yapalim

        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement submitButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("cansu@hotmail.com");
        passwordKutusu.sendKeys("12345");
        submitButonu.click();


        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();

        ReusableMethods.bekle(2);
    }
}
