package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class Ornek06_ActionClass extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1- https://the-internet.herokuapp.com/context_menu sitesine gidin
            2- Cizili alan uzerinde sag click yapin
            3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
            4- Tamam diyerek alert’i kapatalim
            5- Elemental Selenium linkine tiklayalim
            6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(cizgiliAlanElementi).perform();
        ReusableMethods.bekle(2);

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";

        Assertions.assertEquals(actualAlertText,expectedAlertText);
        ReusableMethods.bekle(2);

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        String ilkSayfaWindowHandle = driver.getWindowHandle();
        String ikinciSayfaWindowHandle = "";

        Set<String> tumWindowHandle = driver.getWindowHandles();
        System.out.println(tumWindowHandle);

        for (String eachWindowHandle : tumWindowHandle){

            if (! eachWindowHandle.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=eachWindowHandle; //ikinci sayfaya, bulunan handle'ı atama yaptık.
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandle); // Webdrive'ı ikinci sayfaya gönderdik

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedH1Tagi = "Elemental Selenium";
        String actualH1Tagi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(actualH1Tagi,expectedH1Tagi);
    }
}
