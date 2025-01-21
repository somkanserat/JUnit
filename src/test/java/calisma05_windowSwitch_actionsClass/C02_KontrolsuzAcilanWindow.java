package calisma05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(actualTitle,expectedTitle);
        ReusableMethods.bekle(2);

        String ilkWindowHandle = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        System.out.println("Click Here'a bastıktan sonra title:"+driver.getTitle());
        ReusableMethods.bekle(2);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ini kaydettikten sonra
            nerede olursak olalim
            driver.switchTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ini de alamayiz
         */

        Set<String> tumWindowHandles = driver.getWindowHandles(); //Tüm windowHandle değerlerini kaydettik
        System.out.println("İlk window handle:"+ilkWindowHandle); //ilk window
        System.out.println("Tüm Window Handle değerleri:"+tumWindowHandles); //tüm window

        String ikinciWindowHandle = ""; // atama yapılacak ikinciWindow

        for (String each : tumWindowHandles){

            if (! each.equals(ilkWindowHandle)){ //ilk window değerini içermiyorsa
                ikinciWindowHandle=each; //each'i, ikinciWindow'a atadık
            }
        }
        ReusableMethods.bekle(1);
        driver.switchTo().window(ikinciWindowHandle); // geçiş yaptık.
        System.out.println("Açılan sayfanın title'ı:"+driver.getTitle());
        ReusableMethods.bekle(1);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText = "New Window";
        actualText = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedText,actualText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        //  “The Internet” olduğunu test edin
        driver.switchTo().window(ilkWindowHandle);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
    }
}
