package calisma02_jUnitFramework;

import java.util.Random;

public class C01_UnitTest {

    public static void main(String[] args) {

        // verilen bir tamsayi kontrol edip
        // 3 basamaklı pozitif bir tam sayi değilse "false"
        // 3 basamakli bir sayi girerse "true" donduren bir method olusturun

        sayiKontrolMethodununTestMethodu();
    }

    public static boolean sayiKontrol(int sayi){

        if (sayi>=100 && sayi <=999){
            return true;
        }
        else {
            return false;
        }
    }

    // sayıKontrol() method'unun, doğru çalışıp çalışmadığını kontrol eden
    // bir test methodu oluşturun

    public static void sayiKontrolMethodununTestMethodu(){

        Random random = new Random();
        boolean testSonucu = true;

        //true döndürmesi gereken 10 değeri test etsin

        for (int i=1; i<=10;i++){

            int randomSayi = 100 + random.nextInt(899); // sınırları belirlemek için bu tanımladık.
            // random.nextInt(899); yazsaydık 0-899 arasında sayıları random çevirecekti.
            // +100 ile sınırlar --> 100-999 haline geldi.

            if( sayiKontrol(randomSayi) == false ){
                // ürettiğimiz sayılar, 100-99 arasında ve sayıKontrol method'u true döndürmeliydi.
                // demek ki sayıKontrol methodu doğru çalışmamakta
                testSonucu = false;
            }
        }
        if (testSonucu == true){
            System.out.println("10 farkli sayi uretildi ve method kontrol testi PASSED");
        }else {
            System.out.println("sayi kontrol method'u dogru calismiyor, Test FAILED");
        }
    }
}
