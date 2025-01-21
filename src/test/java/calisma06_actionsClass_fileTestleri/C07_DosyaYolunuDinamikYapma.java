package calisma06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin
        String downloadsDenemeDosyaYolu = "C:\\Users\\Serat\\Downloads\\deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(downloadsDenemeDosyaYolu)) );

        /*
            /Users/ahmetbulutluoz       /Users/ahmetbulutluoz        /Downloads/deneme.txt
            \\Users\\Cansu              C:\Users\Cansu               \\Downloads\\deneme.txt
            C:\\Users\\Hamza            C:\Users\Hamza               \\Downloads\\deneme.txt
            C:\\Users\\coban            C:\Users\coban               \\Downloads\\deneme.txt
         */

        /*
            "user.dir" --> C:\Users\Serat\IdeaProjects\JUnit
            "user.home" --> C:\Users\Serat
         */

        String dinamikAnaDosyaYolu = System.getProperty("user.home");
        System.out.println(dinamikAnaDosyaYolu); //C:\Users\Serat

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        /*
            eger dosya yolunu normal olarak yazarsak
            /Users/Serat/Downloads/deneme.txt
            sadece dosya yolunu olusturan kisinin bilgisayarinda calisir
            baska bilgisayarlarda calismaz

            Java ortak calisabilmemiz icin
            her kisinin bilgisayarinda farkli olan bastaki kismi
            alabilecegimiz bir kod hazirlamistir

            herkeste farkli olan kisim  :  /Users/Serat
            herkeste ortak olan kisim   :  /Downloads/deneme.txt
         */

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/deneme.txt";
        Assertions.assertTrue(  Files.exists(Paths.get(dinamikDosyaYolu)) );

        // day09 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        String denemeDosyaYolu = "src/test/java/calisma6_ActionsClass_fileTestleri/deneme.txt";

        System.out.println(      Files.exists(Paths.get(denemeDosyaYolu))     ); // true

        /*
             C:\Users\Serat\IdeaProjects\JUnit\src\test\java\calisma6_ActionsClass_fileTestleri\deneme.txt  --> copy Path --> Absolute path
         */

        System.out.println( System.getProperty( "user.dir"  ) );
        //  herkeste farkli olan kisim :    C:\Users\Serat\IdeaProjects\JUnit
        //  herkeste ayni olan kisim   :    \src\test\java\calisma6_ActionsClass_fileTestleri\deneme.txt

        String dinamikProjeDosyaYolu = System.getProperty( "user.dir"  );

        dinamikDosyaYolu = dinamikProjeDosyaYolu + "/src/test/java/calisma6_ActionsClass_fileTestleri/deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(dinamikDosyaYolu)));

    }
}
