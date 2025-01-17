package calisma02_jUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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

public class C07_JUnitAssertions {

    /* 3 farklı test metodu oluşturarak aşağıdaki testleri gerçekleştirin
         1- Test otomasyonu anasayfasına gidin,
            Url'nin "test otomasyonu" içerdiğini test edin.
         2- "phone" için arama yapın ve arama sonucunda ürün bulunabildiğini test edin.
         3- ilk ürüne tıklayın ve açılan sayfadaki ürün isminde case sensitive olmadan
            "phone" bulunduğunu test edin.
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

        Assertions.assertTrue( actualUrl.contains(expectedUrl) , "Url, beklenildiği gibi değil." );
        // FAILED OLDUĞUNDA, assertTrue'nin altı turuncu noktalar ile çizilir.
        // FAILED OLDUĞUNDA message bırakabilirsiniz.
    }

    @Test
    public void test02(){   //UrunAramaTesti
        // 2- "phone" için arama yapın ve arama sonucunda ürün bulunabildiğini test edin.

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        List<WebElement> urunElementleriList = driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assertions.assertTrue( urunElementleriList.size()>0 ,"Arama sonucunda ürün bulunamadı." );
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

        Assertions.assertTrue( actualIsim.contains(expectedIsim) ,"Ürün ismi phone içermiyor." );
    }
}
