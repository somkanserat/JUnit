package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.ArrayList;
import java.util.List;

public class C06_DropdownMenu extends TestBaseEach {

    @Test
    public void test01(){
        // https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

            // 1.adim : dropdown menuyu locate edip, bir webelement olarak class'da kaydedelim
        WebElement gundDm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
            // 2.adim : bir select objesi olusturun ve parametre olarak
            // kullanmak istediginiz dropdown menuyu girin
        Select selectGun = new Select(gundDm);
            // 3.adim : olusturdugumuz selectGun objesi sayesinde
            // Select class'indaki hazir method'lar ile istenen islemleri yapabiliriz
        selectGun.selectByIndex(5); // günü artık 5 olarak seçtik.
        //selectGun.selectByValue("5");

        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        WebElement aydDm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(aydDm);
        selectAy.selectByValue("nisan"); // value olarak nisan'ı seçtik.

        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yildDm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yildDm);
        selectYil.selectByVisibleText("1990");
        // selectByVisibleText --> görünür değere göre seçim yapar.
        //selectByValue --> HTML'deki value attribute değeri

        //4. Secilen değerleri konsolda yazdirin
        // System.out.println(selectGun);// org.openqa.selenium.support.ui.Select@87083425
        // System.out.println(selectGun.toString()); // org.openqa.selenium.support.ui.Select@9f8b5914
        System.out.println(selectGun.getFirstSelectedOption().getText()); //5
        // getFirstSelectedOption() --> seçili olan gün değeri getirecek
        System.out.println(selectAy.getFirstSelectedOption().getText()); //Nisan
        // getFirstSelectedOption() --> seçili olan ay değeri getirecek
        System.out.println(selectYil.getFirstSelectedOption().getText()); //1990
        // getFirstSelectedOption() --> seçili olan yıl değeri getirecek

        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> aydDmOptionElementleriList = selectAy.getOptions(); //tüm elementleri getirir.

        for (WebElement eachElement : aydDmOptionElementleriList){
            System.out.println(eachElement.getText());
        }

        // Ay dropdown menusunde "Ocak" degerinin bulundugunu test edin

            // **1.YÖNTEM: dropdown uzerinden olusturdugumuz selectAy.getText() menudeki
            // tum ay isimlerini getirir

        String expectedAyIcerik = "Ocak";
        String actualAyIcerik = aydDm.getText();
        //System.out.println("actualAyIcerik : " + actualAyIcerik); --> tüm ay'ları bize yazdıracak.
        Assertions.assertTrue(actualAyIcerik.contains(expectedAyIcerik),"Ocak ayını içermemektedir.");

            // **2.YÖNTEM: tum opsiyonlarin yazilarini olusturdugumuz String bir listeye ekleyebiliriz
            // sonra list.contains() ile testimizi yapabiliriz

        List<String> tumListeStr = new ArrayList<>();
        for (WebElement eachBaslik : aydDmOptionElementleriList){

            tumListeStr.add(eachBaslik.getText());
        }
        String expectedBaslikIsmi = "Ocak";
        Assertions.assertTrue(tumListeStr.contains(expectedBaslikIsmi));

            // **3.YONTEM: ReusableMethods class'indaki method'u kullanalim
            // (Yukarıdaki işlemi metotlaştırıp, tekrardan kullandık.)
        List<String> ayDropdownMenuMetinler = ReusableMethods.stringListeyeDonustur(aydDmOptionElementleriList);
        Assertions.assertTrue(ayDropdownMenuMetinler.contains("Ocak"));

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedDropdownBoyutu = 13;
        int actualDropdownBoyutu = aydDmOptionElementleriList.size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);
        ReusableMethods.bekle(2);

    }
}
