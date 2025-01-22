package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek07_ActionClass extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1- https://demoqa.com/droppable adresine gidelim
            2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
            3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
         */

        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElementi = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drophereElementi = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(4);
        actions.dragAndDrop(dragMeElementi,drophereElementi).perform();
        ReusableMethods.bekle(4);
        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedDroppedYazisi = "Dropped!";
        String actualDroppedYazisi = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();

        Assertions.assertEquals(actualDroppedYazisi,expectedDroppedYazisi);
        ReusableMethods.bekle(2);
    }
}
