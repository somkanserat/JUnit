package calisma05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_Actions_DragAndDrop extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1- https://testotomasyonu.com/droppable adresine gidelim
            2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
            3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
            4- Sayfayi yenileyin
            5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
            6- “Drop Here” yazisinin degismedigini test edin
         */

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement acceptableButton = driver.findElement(By.xpath("//*[@id='draggable2']"));
        WebElement dropHereButton = driver.findElement(By.xpath("//*[@id='droppable2']"));

        WebElement yaziElemeti = driver.findElement(By.xpath("//*[text()='Drop Here']"));
        String dropHereYazisi = yaziElemeti.getText();

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.dragAndDrop(acceptableButton,dropHereButton).perform();
        ReusableMethods.bekle(1);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
            //Drop Here yazısını görmek için, yukarıdaki acceptableButonunu koymadan önceki halini aldık.
            //Daha sonra butonu koyduktan sonra yeni halini aldık.
        yaziElemeti = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String droppedYazisi = yaziElemeti.getText();

        Assertions.assertNotEquals(dropHereYazisi, droppedYazisi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        yaziElemeti = driver.findElement(By.xpath("//*[text()='Drop Here']"));
        String yaziElementiStr = yaziElemeti.getText();

        WebElement notAcceptableButton = driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));

        dropHereButton = driver.findElement(By.xpath("//*[@id='droppable2']"));
        ReusableMethods.bekle(1);
        actions.dragAndDrop(notAcceptableButton,dropHereButton).perform();
        ReusableMethods.bekle(2);

        //6- “Drop Here” yazisinin degismedigini test edin
        yaziElemeti = driver.findElement(By.xpath("//*[text()='Drop Here']"));
        String yaziElementiStrSonHali = yaziElemeti.getText();

        Assertions.assertEquals(yaziElementiStr, yaziElementiStrSonHali);


    }
}
