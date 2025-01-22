package ornekler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek08_KeyboardActionClass extends TestBaseEach {

    @Test
    public void test01(){

        /*
            1- https://www.facebook.com adresine gidelim
            2- Yeni hesap olustur butonuna basalim
            3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
            4- Kaydol tusuna basalim
         */

        //1-https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2-Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
            //ad,soyad
        WebElement adinButonu = driver.findElement(By.xpath("//*[text()='Adın']"));
        Actions actions = new Actions(driver);

        actions.click(adinButonu)
                .sendKeys("Ajda")
                .sendKeys(Keys.TAB)
                .sendKeys("Kahve").perform();
        ReusableMethods.bekle(2);

            //doğum tarihi
        WebElement gunDdm = driver.findElement(By.xpath("//*[@id='day']"));
        Select gun = new Select(gunDdm);
        gun.selectByValue("20");

        WebElement ayDdm = driver.findElement(By.xpath("//*[@id='month']"));
        Select ay = new Select(ayDdm);
        ay.selectByVisibleText("Mar");

        WebElement yilDdm = driver.findElement(By.xpath("//*[@id='year']"));
        Select yil = new Select(yilDdm);
        yil.selectByValue("2000");
        ReusableMethods.bekle(2);

            //cinsiyet
        driver.findElement(By.xpath("(//*[@id='sex'])[2]")).click();
            //cepTel
        WebElement cepTelKutusu = driver.findElement(By.xpath("//*[@aria-label='Cep telefonu numarası veya e-posta']"));
        cepTelKutusu.sendKeys("555");
        ReusableMethods.bekle(2);

        WebElement sifreKutusu = driver.findElement(By.xpath("//*[@id='password_step_input']"));
        sifreKutusu.sendKeys("123456");
        ReusableMethods.bekle(2);

        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//*[text()='Kaydol']")).click();
        ReusableMethods.bekle(5);
    }
}
