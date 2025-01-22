package automationexercisesSitesi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class TestCase06_ContactUsForm extends TestBaseEach {

    /*
        1. 'http://automationexercise.com' adresine gidin
        2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        3. 'Contact Us' butonuna tıklayın
        4. 'GET IN TOUCH' ifadesinin görünür olduğunu doğrulayın
        5. Adınızı, e-postanızı, konunuzu ve mesajınızı girin
        6. Dosyayı yükleyin
        7. 'Submit' butonuna tıklayın
        8. OK butonuna tıklayın
        9. Başarı mesajının 'Success! Your details have been submitted successfully.' görünürlülüğünü test edin
        10. 'HOME' düğmesine tıklayın ve ana sayfaya başarıyla ulaştığınızı doğrulayın.
     */

    @Test
    public void test01(){

        //1. 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");

        //2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedBaslik = "Automation Exercise";
        String actualBaslik = driver.getTitle();

        Assertions.assertTrue(actualBaslik.contains(expectedBaslik));

        //3. 'Contact Us' butonuna tıklayın
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        //4. 'GET IN TOUCH' ifadesinin görünür olduğunu doğrulayın
        String expectedGetInTouchYazisi = "GET IN TOUCH";
        String actualGetInTouchYazisi = driver.findElement(By.xpath("//h2[text()='Get In Touch']")).getText();

        Assertions.assertTrue(actualGetInTouchYazisi.equals(expectedGetInTouchYazisi));

        //5. Adınızı, e-postanızı, konunuzu ve mesajınızı girin
        WebElement nameKutusu = driver.findElement(By.xpath("//*[@placeholder='Name']"));
        nameKutusu.sendKeys("abc");
        ReusableMethods.bekle(1);

        WebElement emailKutusu = driver.findElement(By.xpath("//*[@placeholder='Email']"));
        emailKutusu.sendKeys("abc@gmail.com");
        ReusableMethods.bekle(1);

        WebElement subjectKutusu = driver.findElement(By.xpath("//*[@placeholder='Subject']"));
        subjectKutusu.sendKeys("abc");
        ReusableMethods.bekle(1);

        WebElement messageKutusu = driver.findElement(By.xpath("//*[@placeholder='Your Message Here']"));
        messageKutusu.sendKeys("abc");
        ReusableMethods.bekle(1);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //6. Dosyayı yükleyin
        WebElement dosyaYukleme = driver.findElement(By.xpath("//*[@name='upload_file']"));
        String dosyaYolu = "C:/Users/Serat/Desktop/images.jpg";
        dosyaYukleme.sendKeys(dosyaYolu);
        ReusableMethods.bekle(1);

        //7. 'Submit' butonuna tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();
        ReusableMethods.bekle(2);

        //8. OK butonuna tıklayın
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);

        //9. Başarı mesajının 'Success! Your details have been submitted successfully.' görünürlülüğünü test edin
        String expectedBasariMesaji = "Success! Your details have been submitted successfully.";
        String actualBasariMesaji = driver.findElement(By.xpath("//*[@class='status alert alert-success']")).getText();

        Assertions.assertTrue(actualBasariMesaji.contains(expectedBasariMesaji));

        //10. 'HOME' düğmesine tıklayın ve ana sayfaya başarıyla ulaştığınızı doğrulayın.
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();

        expectedBaslik = "Automation Exercise";
        actualBaslik = driver.getTitle();

        Assertions.assertTrue(actualBaslik.contains(expectedBaslik));

    }
}
