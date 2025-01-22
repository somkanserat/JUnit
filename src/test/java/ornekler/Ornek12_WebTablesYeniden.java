package ornekler;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class Ornek12_WebTablesYeniden extends TestBaseEach {

    /*
            1. “https://demoqa.com/webtables” sayfasina gidin
            2. Headers da bulunan basliklari yazdirin
            3. 3.sutunun basligini yazdirin
            4. Tablodaki tum datalari yazdirin
            5. Tabloya yeni değer ataması yapın
            6. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
            7. Tablodaki satir sayisini yazdirin
            8. Tablodaki sutun sayisini yazdirin
            9. Tablodaki 3.kolonu yazdirin
            10. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
            11. Method olusturun, Test sayfasindan satir ve sutun
            sayisini girdigimde bana datayi yazdirsin
         */
    @Test
    public void test01(){

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersIsimleri = driver.findElements(By.xpath("//*[@role='columnheader']"));
        System.out.println(ReusableMethods.stringListeyeDonustur(headersIsimleri));

        //3. 3.sutunun basligini yazdirin
        System.out.println(headersIsimleri.get(2).getText());

        //4. Tablodaki tum datalari yazdirin ve data sayısının 70 olduğunu kontrol edin.
        List<WebElement> tumDatalar = driver.findElements(By.xpath("//*[@role='gridcell']"));
        System.out.println(ReusableMethods.stringListeyeDonustur(tumDatalar));

        int expectedDataSayisi = 70;
        int actualDataSayisi = tumDatalar.size();

        Assertions.assertEquals(expectedDataSayisi,actualDataSayisi);

        //5 Tabloya yeni değer ataması yapın
        driver.findElement(By.xpath("//*[@id='addNewRecordButton']")).click();
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        ReusableMethods.bekle(1);
        WebElement firstNameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));
        actions.click(firstNameKutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys("33")
                .sendKeys(Keys.TAB).sendKeys("5000")
                .sendKeys(Keys.TAB).sendKeys("QA").perform();
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        ReusableMethods.bekle(2);


        //6. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosOlmayanData = 0;
        String unExpectedData = "";
        tumDatalar = driver.findElements(By.xpath("//*[@role='gridcell']"));
        //tümDatalar'ı tekrar locate ettik. Bayatladığı için bu şekilde tekrar hatırlatmak gerekir.

        for (WebElement webElement : tumDatalar) {
            String eachData = webElement.getText();

            if (!eachData.replaceAll("\\s", "").equals(unExpectedData)) {
                bosOlmayanData++;
            }
        }

        List<WebElement> actionButtons = driver.findElements(By.xpath("//*[@class='action-buttons']"));
        int actionButtonSayisi = actionButtons.size();
        bosOlmayanData+=actionButtonSayisi;
        System.out.println("Boş olmayan data sayısı: "+bosOlmayanData);

        //7. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("Tablodaki satır sayısı:" +satirSayisi.size());

        //8. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sütun sayısı:"+headersIsimleri.size());

        //9. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='row']/div[@role='gridcell'][3]"));
        System.out.println("3.Sütun Elementleri:"+ReusableMethods.stringListeyeDonustur(ucuncuSutunElementleriList));

        //10. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        tumDatalar = driver.findElements(By.xpath("//*[@role='gridcell']"));

        for (int i=0; i<tumDatalar.size();i++){
            String data = tumDatalar.get(i).getText();

            if (data.equals("Kierra")){
                System.out.println("Kierra'nın maaşı:"+tumDatalar.get(i+4).getText());

            }
        }

        //11. Method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println(getHucreData(1,3));

    }

    public String getHucreData(int satirNo,int sutunNo){

        //*[@role='row'][1]/div[@role='gridcell'][1]
        //*[@role='row']   /div[@role='gridcell']
        String dinamikXpath = "(//div[@role='row'])["+(satirNo+1)+"]/div[@role='gridcell']["+sutunNo+"]";
        WebElement hedefData = driver.findElement(By.xpath(dinamikXpath));
        return hedefData.getText();
    }
}
