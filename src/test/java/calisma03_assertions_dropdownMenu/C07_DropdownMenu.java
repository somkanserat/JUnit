package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_DropdownMenu extends TestBaseEach {

    /*
        https://the-internet.herokuapp.com/dropdown adresine gidin.
         1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
         2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
         3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
         4.Tüm dropdown değerleri(value) yazdırın
         5. Dropdown’un boyutunun 4 olduğunu test edin
    */

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']")); //dropdown'ı web element olarak kaydettik
        System.out.println(ddm.getText());
        Select select = new Select(ddm);
        ReusableMethods.bekle(2);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println("Index kullanarak option1:" +select.getFirstSelectedOption());
        ReusableMethods.bekle(2);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("Value kullanarak option2:" +select.getFirstSelectedOption());
        ReusableMethods.bekle(2);

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Visible Text kullanarak option1" +select.getFirstSelectedOption());
        ReusableMethods.bekle(2);

        //4.Tüm dropdown değerleri(value) yazdırın
            //1.Alternatif
        System.out.println("Tüm dropdown:" +ddm.getText());

            //2.Alternatif
        System.out.println(
                "Tüm dropdown(metot ile)" + ReusableMethods.stringListeyeDonustur(select.getOptions())
        );

        //5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedDropdownBoyutu = 4;
        int actualDropdownBoyutu = select.getOptions().size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);
    }
}
