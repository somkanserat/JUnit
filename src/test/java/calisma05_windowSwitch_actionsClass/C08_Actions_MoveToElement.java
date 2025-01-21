package calisma05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_Actions_MoveToElement extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1- https://www.testotomasyonu.com/ adresine gidin
            2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
            3- “Boys” linkine basin
            4- Acilan sayfadaki ilk urunu tiklayin
            5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
         */

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kidsWearButton = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));

        actions.moveToElement(kidsWearButton).perform();

        //3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[.='Boys']")).click();
        ReusableMethods.bekle(2);

        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-title mb-3 '])[1]")).click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']")).getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);
        ReusableMethods.bekle(2);
    }
}
