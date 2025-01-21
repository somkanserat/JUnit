package calisma05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C09_KeyboardActions extends TestBaseEach {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com sayfasina gidelim
        //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin
        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin
        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT).sendKeys("dell c") //DELL C
                .keyUp(Keys.SHIFT).sendKeys("ore ") //DELL Core
                .keyDown(Keys.SHIFT).sendKeys("i")   //DELL Core I
                .keyUp(Keys.SHIFT).sendKeys("3")    //DELL Core I3
                .sendKeys(Keys.ENTER).perform();


        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        ReusableMethods.bekle(3);

    }
}
