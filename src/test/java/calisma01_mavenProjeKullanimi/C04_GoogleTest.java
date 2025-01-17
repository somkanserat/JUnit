package calisma01_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        ReusableMethods.bekle(1); // 1sn bekleme --> başka class'dan çağırılan metot

        //3- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedBaslik = "Google"; //beklenen başlık
        String actualBaslik = driver.getTitle(); // asıl başlık

        if (actualBaslik.contains(expectedBaslik)){ // if ile kontrol
            System.out.println("Test is PASSED");
        }else {
            System.out.println("Test is FAILED");
        }

        //4- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='q']")); // AramaKutusu adında WebElement oluşturduk
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER); // aramaKutusuna "Nutell" yazdık ve arattık

        ReusableMethods.bekle(2); //2sn bekleme
        driver.quit();// sayfa kapat

    }
}
