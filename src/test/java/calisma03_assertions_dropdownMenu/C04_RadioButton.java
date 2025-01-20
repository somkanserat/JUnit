package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_RadioButton {

    //	a. Verilen web sayfasına gidin.
    //	      https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void yazidanSecimTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        //	b. Cinsiyet Radio button elementlerini locate edin

        driver.get("https://testotomasyonu.com/form");

        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        WebElement erkekButtonYazisi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));


        //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan
        //	size uygun olani secin

        erkekButtonYazisi.click(); //yazının üzerine tıkladık
        ReusableMethods.bekle(1);

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
        ReusableMethods.bekle(1);
    }

    @Test
    public void buttondanSecimTesti(){

        driver.get("https://testotomasyonu.com/form");

        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        erkekButton.click(); // butona tıkladık
        ReusableMethods.bekle(1);

        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
        ReusableMethods.bekle(1);
    }
}
