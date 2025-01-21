package calisma06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void test01(){

        // day09 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        /*
            Selenium'da tum islerimizi WebDriver ile yapiyoruz
            Olusturdugumuz driver objesi bizim adimiza
            istedigimiz tum islemleri yapiyor

            ANNNNCAAAAK WebDriver adindan da anlasilacagi gibi
            Web'de kullanilabilir, bilgisayarimizdaki fiziki dosyalara erisemez

            Bilgisayarimizdaki dosyalara erismek icin Java'dan yardim aliriz
            Java ile dosyaya ulasabilmemiz icin ise
            dosyanin dosyayolunu bilmeliyiz
         */

        String denemeDosyaYolu = "src/test/java/calisma6_ActionsClass_fileTestleri/deneme.txt";
        //deneme.txt'nin üzerine gelip sağ click --> copy path/Reference --> src olanı al

        System.out.println(      Files.exists(Paths.get(denemeDosyaYolu))     ); // true

        String yanlisDosyaYolu = "src/test/java/calisma6_ActionsClass_fileTestleri/deneme1.txt";

        System.out.println(  Files.exists(Paths.get(yanlisDosyaYolu))  ); // false
        //exists --> var olmak, varlığını kontrol ettik

        Assertions.assertTrue(  Files.exists(Paths.get(denemeDosyaYolu))   ); // PASSED

        // day09 package'i altinda deneme1.txt dosyasinin
        // var olmadigini test edin

        Assertions.assertFalse( Files.exists(Paths.get(yanlisDosyaYolu)) ); // PASSED

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String downloadsDenemeDosyaYolu = "C:\\Users\\Serat\\Downloads\\deneme.txt";
        //String downloadsDenemeDosyaYolu = "C:/Users/Serat/Downloads/deneme.txt";  --> bu da kabul edilebilir

        Assertions.assertTrue( Files.exists(Paths.get(downloadsDenemeDosyaYolu)) );

    }
}
