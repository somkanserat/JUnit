package calisma02_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C08_BeforeVeAfterSartMi {

    /* Tek test metodu oluşturarak aşağıdaki testleri gerçekleştirin
         1- Test otomasyonu anasayfasına gidin,
            Url'nin "test otomasyonu" içerdiğini test edin.
         2- "phone" için arama yapın ve arama sonucunda ürün bulunabildiğini test edin.
         3- ilk ürüne tıklayın ve açılan sayfadaki ürün isminde case sensitive olmadan
            "phone" bulunduğunu test edin.
     */

    /*
        Verilen görev tek bir test metodu ile yapılacak bir görev olsa da
        Web driver'ı oluşturma ve kapatma işlemini ayrı bir setup() ve teardown() ile yapmayı tercih ederiz.

        Eğer tek bir test metodunun içinde Webdriver oluşturma ve sonunda driver'ı kapatma işlemlerini yaparsak,
        Test failed olduğunda expection oluştuğu için
        kodun çalışması durur ve son satırdaki driver.quit() çalışmaz.

        Özellikle toplu çalışmalarda kapanmayan browser'ların olması iyi olmaz.
     */

    WebDriver driver;

    @BeforeEach
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void urunTesti(){


        driver.get("https://testotomasyonu.com/");
        // Url'nin "test otomasyonu" içerdiğini test edin.
        ReusableMethods.bekle(2);

        String expectedUrl = "testotomasyonu1";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue( actualUrl.contains(expectedUrl) , "Url, bekleildiği gibi değil." );

        // 2-phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
        aramaKutusu.sendKeys("phonex"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        List<WebElement> urunElementleriList = driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assertions.assertTrue( urunElementleriList.size()>0 ,"Arama sonucunda ürün bulunamadı." );

        //3 ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();//ilk ürüne tıkladık.
        ReusableMethods.bekle(1);

        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsim = "phonexxx";
        String actualIsim = ilkUrunIsmiElementi.getText().toLowerCase();

        Assertions.assertTrue( actualIsim.contains(expectedIsim) ,"Ürün ismi phone içermiyor." );

    }
}
