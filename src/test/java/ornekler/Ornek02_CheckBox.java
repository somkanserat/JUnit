package ornekler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek02_CheckBox extends TestBaseEach {

    /*
        Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        a. Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        b. Checkbox1 ve checkbox2 elementlerini locate edin.
        c. Checkbox1 seçili değilse onay kutusunu tıklayın
        d. Checkbox2 seçili değilse onay kutusunu tıklayın
        e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
     */

    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        ReusableMethods.bekle(2);

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        boolean checkBox1Secili = checkBox1.isSelected();
        if ( ! checkBox1Secili ){
            System.out.println("Checkbox1 seçili değil");
            checkBox1.click();
        }
        ReusableMethods.bekle(2);

        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        boolean checkBox2Secili = checkBox2.isSelected();
        if (! checkBox2Secili ){
            System.out.println("Checkbox2 seçili değil");
            checkBox2.click();
        }
        ReusableMethods.bekle(2);

        //e. Checkbox1 ve Checkbox2’nin seçili olduğunu test edin
        Assertions.assertTrue(checkBox1.isSelected());
        Assertions.assertTrue(checkBox2.isSelected());
        ReusableMethods.bekle(1);
    }
}
