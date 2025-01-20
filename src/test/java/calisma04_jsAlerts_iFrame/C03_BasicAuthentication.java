package calisma04_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C03_BasicAuthentication extends TestBaseEach {

    //1- Bir class olusturun : BasicAuthentication
    //2- https://testotomasyonu.com/basicauth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //
    //Html komutu : https://username:password@URL
    //	Username     : membername
    // 	password      : sunflower
    //

    // driver.get("https://testotomasyonu.com/basicauth");
    // sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
    // ancak otomasyon ile gittigimizde
    // kullanici adi ve sifresi bolumunu locate edemedigimizden kullanamayiz
    // bunun yerine kullandigimiz url'in sahibi olan sirketin
    // bize verecegi kullanici adi ve sifresini
    // yine sirketin bize tarif edecegi yontemle URL'e eklemeliyiz

    @Test
    public void test01(){
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basicAuthYaziElementi = driver.findElement(By.tagName("h1"));
        ReusableMethods.bekle(2);

        Assertions.assertTrue(basicAuthYaziElementi.isDisplayed());
    }


}
