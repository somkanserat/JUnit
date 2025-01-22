package ornekler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class Ornek12_WebTables extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1. “https://demoqa.com/webtables” sayfasina gidin
            2. Headers da bulunan basliklari yazdirin
            3. 3.sutunun basligini yazdirin
            4. Tablodaki tum datalari yazdirin
            5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
            6. Tablodaki satir sayisini yazdirin
            7. Tablodaki sutun sayisini yazdirin
            8. Tablodaki 3.kolonu yazdirin
            9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
            10. Method olusturun, Test sayfasindan satir ve sutun
            sayisini girdigimde bana datayi yazdirsin
         */

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> tumBasliklar = driver.findElements(By.xpath("//*[@role='row']/div[@role='columnheader']"));
        System.out.println("Başlıklar Listesi:" + ReusableMethods.stringListeyeDonustur(tumBasliklar));
        ReusableMethods.bekle(1);

        //3. 3.sutunun basligini yazdirin
        System.out.println("3.sütunun başlığı:"+tumBasliklar.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalarList = driver.findElements(By.xpath("//*[@role='row']/div[@role='gridcell']"));
        System.out.println("Tüm Datalar:"+ReusableMethods.stringListeyeDonustur(tumDatalarList));
        ReusableMethods.bekle(1);

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> actionButonlari = driver.findElements(By.xpath("//*[@class='action-buttons']"));

        String unExpectedData = "";
        int bosOlmayanData = 0;
        System.out.println(tumDatalarList.size());

        for (int i=0; i<tumDatalarList.size();i++){//tüm dataları kontrol ederiz.

            if ( (!tumDatalarList.get(i).getText().replaceAll("\\s","").equals(unExpectedData))){
                //1.ADIM: Dataların içerisindeki boşluk değerlerini, hüçlik ile değiştirdik.
                //2.ADIM: Data değerlerini, beklenmeyenData(hiçlik) değeri ile karşılaştırdık
                bosOlmayanData++;
                //3.ADIM: EĞER value değerleri, unExpectedData'ya eşit değilse (Value değeri, hiçlik değilse)
                //        boşOlmayanData değerini arttırdık
            }
        }

        System.out.println("Boş olmayan data sayısı:"+bosOlmayanData);

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("Tablodaki Satır Sayısı:"+satirSayisi.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki Sütun Sayısı:"+tumBasliklar.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='row']/div[@role='gridcell'][3]"));
        System.out.println("3.Sütun Elementleri:"+ReusableMethods.stringListeyeDonustur(ucuncuSutunElementleriList));

        //10.Method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println(getHucreData(2,2)); //Cantrell
        System.out.println(getHucreData(3,6)); //Legal
        System.out.println(getHucreData(10,7)); //
        System.out.println(getHucreData(1,3)); //39

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("Kierra'nın Maaşı:"+getHucreData(3,1));
        //Kierra'nın Maaşı:Kierra

    }


    public String getHucreData(int satirNo,int sutunNo){

        //*[@role='row'][1]/div[@role='gridcell'][1]
        //*[@role='row']   /div[@role='gridcell']
        String dinamikXpath = "(//div[@role='row'])["+(satirNo+1)+"]/div[@role='gridcell']["+sutunNo+"]";
        WebElement hedefData = driver.findElement(By.xpath(dinamikXpath));
        return hedefData.getText();
    }
}
