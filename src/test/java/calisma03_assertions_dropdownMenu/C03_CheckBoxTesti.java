package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_CheckBoxTesti {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown(){

        driver.quit();
    }

    @Test
    public void checkBoxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiCheckBox.click();
        ReusableMethods.bekle(2);
        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        carpintiCheckBox.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());
        ReusableMethods.bekle(2);

        //	d. Seker ve Epilepsi checkbox’larininin seçili
        //     olmadigini test edin

        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());

    }
}
