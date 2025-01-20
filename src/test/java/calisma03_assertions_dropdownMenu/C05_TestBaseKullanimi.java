package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_TestBaseKullanimi extends TestBaseEach {

    /*
        Java'da OOP consept'in en buyuk avantaji REUSABILITY'dir. Yani yeniden kullanılabilirlik.

        @BeforeEach - @AfterEach
        @BeforeAll - @AfterAll
        method'lari her class'da ayni sekilde yeniden yazmak yerine
        baska bir class'da olusturabiliriz

        Baska bir class'da bulunan class uyelerine
        ulasmanin en kisa yolu inheritance'dir
        'extend' ile en kolay şekilde ulaşırız.

        biz de utilities altinda TestBase class'i olusturup
        before ve after method'larini o class'lara koyabiliriz

     */

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

    }
}
