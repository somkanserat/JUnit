package ornekler;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class Ornek10_FakerClass extends TestBaseEach {
    /*
        1. "https://facebook.com"  Adresine gidin
        2. “create new account”  butonuna basin
        3. “firstName” giris kutusuna bir isim yazin ve “surname” giris kutusuna bir soyisim yazin
        4. Doğum tarihini girin
        5. Cinsiyet seçin ve Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        6. “email” yazın
        7. Bir sifre girin
        8. Sayfayi kapatin
     */

    @Test
    public void test01(){

        //1."https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //2.“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
        ReusableMethods.bekle(2);

        //3. “firstName” giris kutusuna bir isim yazin ve “surname” giris kutusuna bir soyisim yazin
        Faker faker = new Faker(); // rastgele değer alabilmek için
        Actions actions = new Actions(driver);

        WebElement firstNameKutusu = driver.findElement(By.xpath("//*[text()='Adın']"));
        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).perform();
        ReusableMethods.bekle(2);

        //4. Doğum tarihini girin
            // tarihler dropdown menü olduğu için, webelement olarak kaydedilip, daha sonra select class'ından yardım alınarak,
            // seçim yapılır.
        WebElement gundDm = driver.findElement(By.xpath("//*[@id='day']"));
        Select selectGun = new Select(gundDm);
        selectGun.selectByValue("12");

        WebElement aydDm = driver.findElement(By.xpath("//*[@id='month']"));
        Select selectAy = new Select(aydDm);
        selectAy.selectByVisibleText("Tem");

        WebElement yildDm = driver.findElement(By.xpath("//*[@id='year']"));
        Select selectYil = new Select(yildDm);
        selectYil.selectByValue("2000");
        ReusableMethods.bekle(2);

        //5. Cinsiyet seçin ve Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement kadinButon = driver.findElement(By.xpath("(//*[@id='sex'])[1]"));
        WebElement erkekButon = driver.findElement(By.xpath("(//*[@id='sex'])[2]"));
        WebElement ozelButon = driver.findElement(By.xpath("(//*[@id='sex'])[3]"));
        erkekButon.click();

        Assertions.assertFalse(kadinButon.isSelected());
        Assertions.assertTrue(erkekButon.isSelected());
        Assertions.assertFalse(ozelButon.isSelected());
        ReusableMethods.bekle(2);

        //6. “email” yazın
        WebElement mailKutusu = driver.findElement(By.xpath("//*[text()='Cep telefonu numarası veya e-posta']"));
        actions.click(mailKutusu).sendKeys(faker.internet().emailAddress()).perform();
        ReusableMethods.bekle(2);

        //7. Bir sifre girin
        WebElement sifreKutusu = driver.findElement(By.xpath("//*[text()='Yeni şifre']"));
        actions.click(sifreKutusu).sendKeys(faker.internet().password()).perform();
        ReusableMethods.bekle(2);
    }
}
