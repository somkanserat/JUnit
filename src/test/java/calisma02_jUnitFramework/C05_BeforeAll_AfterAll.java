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

public class C05_BeforeAll_AfterAll {

    /* 3 farklı test metodu oluşturarak aşağıdaki testleri gerçekleştirin
         1- Test otomasyonu anasayfasına gidin,
            Url'nin "test otomasyonu" içerdiğini test edin.
         2- "phone" için arama yapın ve arama sonucunda ürün bulunabildiğini test edin.
         3- ilk ürüne tıklayın ve açılan sayfadaki ürün isminde case sensitive olmadan
            "phone" bulunduğunu test edin.
     */

    /*
        Bu görev için, her test metodundan sonra driver'ı kapatmak (@AfterEach) mantıklı olmaz.
        bunun yerine, class çalışmaya başladığında, hiçbir metot çalışmadan önce, driver'ı oluşturmak
        ve tüm test metodlar çalışıp bittikten sonra, çalışacak @Test metodu kalmadığında,
        driver'ı kapatmak mantıklı olur.
     */

    /*
        Bu tür, birbirinin sonucuna bağlı test metotları olduğunda, JUnit ile metodları tek tek RUN edebiliriz
        ancak metodun yapması gereken işlevi yapması mümkün değildir.

        BeforeAll ve AfterAll notasyonu kullanan metodların, MUTLAKA STATIC olması gerekmektedir.
        driver'ın kullanılabilmesi için, onun da static olması gerekir.
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

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Anasayfa Testi PASSED");
        }else {
            System.out.println("Anasayfa Testi FAILED");
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
        }
    }

    @Test
    public void test03(){   //ilkUrunIsimTesti
    // 3- ilk ürüne tıklayın ve açılan sayfadaki ürün isminde case sensitive olmadan
    //"phone" bulunduğunu test edin.

        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();//ilk ürüne tıkladık.
        ReusableMethods.bekle(1);

        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsim = "phone";
        String actualIsim = ilkUrunIsmiElementi.getText().toLowerCase();

        if (actualIsim.contains(expectedIsim)){
            System.out.println("Ürün İsmi Testi PASSED");
        }
        else {
            System.out.println("Ürün İsmi Testi PASSED");
        }
    }
}
