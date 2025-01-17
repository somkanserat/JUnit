package calisma02_jUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C06_Assertions {

    /* 3 farklı test metodu oluşturarak aşağıdaki testleri gerçekleştirin
         1- Test otomasyonu anasayfasına gidin,
            Url'nin "test otomasyonu" içerdiğini test edin.
         2- "phone" için arama yapın ve arama sonucunda ürün bulunabildiğini test edin.
         3- ilk ürüne tıklayın ve açılan sayfadaki ürün isminde case sensitive olmadan
            "phone" bulunduğunu test edin.
     */

    /*
        JUnit, bir test metodunun PASSED veya FAILED olmasına,
        kodların sorunsuz olarak çalışıp, bitip bitmemesine göre karar verir.

        Biz if-else ile test yaparsak, if-else FAILED yazdırsa bile
        kodlar problem olmadan çalışmaya devam edeceği için
        metodun sonunda JUnit, test passed olarak algılar ve yeşil tik koyar.

       özellikle toplu test çalıştırmalarında, konsolu inceleyip, test PASSED veya Test FAILED sonucunu aramak
       neredeyse imkansızdır.

       Eğer if ile test yapıyorsak ve failed olduğunda JUnitin'de bunu algılamasını istersek,
       throw keyword'u ile kontrollü Expection oluşturabiliriz.
     */

    static WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void teardown(){
        driver.quit();
    }

    @Test
    public void test01() {  //anasayfaTesti
        // 1- Test otomasyonu anasayfasına gidin,
        driver.get("https://testotomasyonu.com/");

        // Url'nin "test otomasyonu" içerdiğini test edin.
        ReusableMethods.bekle(2);

        String expectedUrl = "testotomasyonu1";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Anasayfa Testi PASSED");
        }else {
            System.out.println("Anasayfa Testi FAILED");
            throw new RuntimeException("actualUrl, expectedUrl'den farklıdır.");
        }
    }

    @Test
    public void test02(){   //UrunAramaTesti
        // 2- "phone" için arama yapın ve arama sonucunda ürün bulunabildiğini test edin.

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        List<WebElement> urunElementleriList = driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        if (urunElementleriList.size()>0){ // urunSayisiList.size() --> bulunan ürün sayısını bize getirir.
            System.out.println("Ürün Arama Testi PASSED");
        }else {
            System.out.println("Ürün Arama Testi FAILED");
            throw new RuntimeException("Ürün bulunamadı.");
        }
    }

    @Test
    public void test03(){   //ilkUrunIsimTesti
        // 3- ilk ürüne tıklayın ve açılan sayfadaki ürün isminde case sensitive olmadan
        //"phone" bulunduğunu test edin.

        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();//ilk ürüne tıkladık.
        ReusableMethods.bekle(1);

        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsim = "phonexxx";
        String actualIsim = ilkUrunIsmiElementi.getText().toLowerCase();

        if (actualIsim.contains(expectedIsim)){
            System.out.println("Ürün İsmi Testi PASSED");
        }
        else {
            System.out.println("Ürün İsmi Testi FAILED");
            throw new RuntimeException("İlk ürün ismi, expected kelimeyi içermiyor.");
        }
    }
}
