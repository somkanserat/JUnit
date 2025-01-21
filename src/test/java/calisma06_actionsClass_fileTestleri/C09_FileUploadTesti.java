package calisma06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C09_FileUploadTesti extends TestBaseEach {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim ve Yuklemek istediginiz dosyayi secelim.

        /*
            ChooseFile butonuna bastigimizda
            bilgisayarimizdaki dosya yapisi cikiyor

            WebDriver ile bilgisayarimizdaki fiziki dosya yapisina
            mudahale edemeyecegimiz icin

            Selenium bize sendKeys(dosyaYolu) yapma firsati verir
         */

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/deneme.txt";

        chooseFile.sendKeys(dinamikDosyaYolu);

        ReusableMethods.bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        ReusableMethods.bekle(2);

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYazisi = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assertions.assertTrue(fileUploadedYazisi.isDisplayed());
        ReusableMethods.bekle(2);
    }
}
