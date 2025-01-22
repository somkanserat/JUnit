package automationexercisesSitesi;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class TestCase06_ContactUsFrom_Faker_WaitClass extends TestBaseEach {

    @Test
    public void test01(){

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

        //1. 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");

        //2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedSayfaTitle = "Automation Exercise";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedSayfaTitle));
        ReusableMethods.bekle(2);

        //3. 'Contact Us' butonuna tıklayın
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        //4. 'GET IN TOUCH' ifadesinin görünür olduğunu doğrulayın
        WebElement getInTouchYazisi = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        wait.until(ExpectedConditions.visibilityOf(getInTouchYazisi));
        ReusableMethods.bekle(2);

        //5. Adınızı, e-postanızı, konunuzu ve mesajınızı girin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@placeholder='Subject']")).sendKeys(faker.music().instrument());
        driver.findElement(By.xpath("//*[@placeholder='Your Message Here']")).sendKeys(faker.animal().name());

        //6. Dosyayı yükleyin
        String dosyaYolu = "C:/Users/Serat/Desktop/dusan.jpg";
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//*[@name='upload_file']"));
        dosyaSecButonu.sendKeys(dosyaYolu);
        ReusableMethods.bekle(2);

        //7. 'Submit' butonuna tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();

        //8. OK butonuna tıklayın
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);

        //9. Başarı mesajının 'Success! Your details have been submitted successfully.' görünürlülüğünü test edin
        WebElement successYazisi = driver.findElement(By.xpath("//*[text()='Success! Your details have been submitted successfully.']"));
        wait.until(ExpectedConditions.visibilityOf(successYazisi));
        ReusableMethods.bekle(1);

        //10. 'HOME' düğmesine tıklayın ve ana sayfaya başarıyla ulaştığınızı doğrulayın.
        driver.findElement(By.xpath("//*[text()=' Home']")).click();

        wait.until(ExpectedConditions.titleIs(expectedSayfaTitle));
        ReusableMethods.bekle(2);


    }
}
