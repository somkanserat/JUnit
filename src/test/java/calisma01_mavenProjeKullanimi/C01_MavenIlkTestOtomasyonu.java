package calisma01_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTestOtomasyonu {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver(); //Selenium'dan WebDriver'ı aldı
        driver.manage().window().maximize(); // Sayfayı büyüttük
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //test otomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");

        //phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id=\"global-search\"]")); // aramaKutusunun Web element olarak kaydettik
        aramaKutusu.sendKeys("phone"+ Keys.ENTER); // arama kutusuna "phone" yazdık ve ENTER'ladık

        //arama sonucunda urun bulunabildiğini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img")); // bulunan elemanların className'ini List'e kaydettik

        if ( bulunanUrunElementleriList.size() > 0){ // if ile kontrol
            System.out.println("Urun arama testi PASSED");
        } else System.out.println("Urun arama testi FAILED");


        //sayfayı kapatın
        ReusableMethods.bekle(3); //başka class'da oluşturduğumuz methodu burada çağırdık
        driver.quit(); //sayfaları kapattık
    }
}
