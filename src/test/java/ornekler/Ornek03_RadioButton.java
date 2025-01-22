package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek03_RadioButton extends TestBaseEach {

    @Test
    public void test01(){
        /*
            a. Verilen web sayfasına gidin.
            https://facebook.com
            b. Cookies’i kabul edin
            c. Create an account buton’una basin
            d. Radio button elementlerini locate edin ve size uygun olani secin
            e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
         */
        //a. Verilen web sayfasına gidin "https://facebook.com"
        driver.get("https://facebook.com");
        ReusableMethods.bekle(2);

        //b. Cookies’i kabul edin

        //c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kadinButton = driver.findElement(By.xpath("(//*[@id='sex'])[1]"));
        WebElement erkekButton = driver.findElement(By.xpath("(//*[@id='sex'])[2]"));
        WebElement digerButton = driver.findElement(By.xpath("(//*[@id='sex'])[3]"));
        erkekButton.click();
        ReusableMethods.bekle(2);

        //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
        ReusableMethods.bekle(2);
    }
}
