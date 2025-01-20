package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    /*
        assertEquals(a,b) ile assertTrue; eğer assertion PASSED olursa
        bu ikisi arasında fark yoktur.

        FAKAT assertion FAILED olursa;
        assertEquals(a,b), expected(a) ve actual(b) değerlerini karşılaştırıp,
        aradaki farkı otomatik olarak bize gösterir.

        ama assertTrue(a==b) kullanıldığında sadece, true bekliyorduk false oldu der.

        Bu sebeple, assertEquals() kullanmayı tercih ederiz.
     */

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https://www.testotomasyonu.com";
    String url2 = "https://www.testotomasyonu.com/";

    @Test
    public void test01(){
        //c'nin a ile b'nin toplamına eşit olduğunu test edin.

        Assertions.assertEquals(c,a+b);
        Assertions.assertTrue(c==a+b); // condition: koşul
    }

    @Test
    public void test02(){
        // b'nin a ile c'nin toplamina esit oldugunu test edin

        Assertions.assertEquals(b,a+c);
        // Expected :20
        // Actual   :40
        // equals kullanıldığında çıktı olarak yukarıdaki gibi sayı döndürür.
    }

    @Test
    public void test03(){
        // b'nin a ile c'nin toplamina esit oldugunu test edin
        Assertions.assertTrue(b==a+c);
        //Expected :true
        //Actual   :false
        // TRUE kullanıldığında çıktı olarak yukarıdaki gibi boolean çıktı döndürür.
    }

    @Test
    public void test04(){
        // url1 ile url2'nin ayni oldugunu test edin

        Assertions.assertEquals(url1,url2);
        // Expected :https://www.testotomasyonu.com
        // Actual   :https://www.testotomasyonu.com/
    }

    @Test
    public void test05(){
        Assertions.assertTrue(url1.equals(url2));

        // Expected :true
        // Actual   :false
    }

    @Test
    public void test06(){
        //url1'in "best" kelimesi icermedigini test edin

//        if ( ! url1.contains("best") ){
//            System.out.println("Best testi PASSED");
//        }else  System.out.println("Best testi FAILED");

        Assertions.assertFalse(url1.contains("best"));

        Assertions.assertTrue( ! url1.contains("best"));
        //'assertTrue()' , 'assertFalse()' olarak basitleştirilebilir.
    }
}
