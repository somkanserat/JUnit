package automationexercisesSitesi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;
import java.util.List;

public class TestCase09_UrunArama extends TestBaseEach {

    @Test
    public void test01(){
        /*
            1. 'http://automationexercise.com' url'sine gidin
            2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
            3. 'Ürünler' düğmesine tıklayın
            4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
            5. Arama girişine ürün adını girin ve arama düğmesine tıklayın
            6. 'SEARCHED PRODUCTS'in görünür olduğunu doğrulayın
            7. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
         */

        //1. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedSayfaBaslik = "Automation Exercise";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Belirli bir süre, bir olayın gerçekleşmesini beklemek için WebDriverWait class'ından nesne oluştururuz.

        wait.until(ExpectedConditions.titleIs(expectedSayfaBaslik));
        //burda da oluşturduğumuz wait nesnesi için işlemler yaparız
        // ExpectedConditions... = Beklenilen koşulu ifade ederiz.
        // titleIs --> eşitlik kontrolü

        ReusableMethods.bekle(1);

        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement searchProductKutusu = driver.findElement(By.xpath("//*[@id='search_product']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchProductKutusu));
        //Görünürlülüğü de sorgulanabilir. --> wait.until(ExpectedConditions.visibilityOf(searchProductKutusu));
        ReusableMethods.bekle(1);

        //5. Arama girişine ürün adını girin ve arama düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("Jeans");
        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
        ReusableMethods.bekle(2);

        //6. 'SEARCHED PRODUCTS'in görünür olduğunu doğrulayın
        WebElement searchedProductsYazisi = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        wait.until(ExpectedConditions.visibilityOf(searchedProductsYazisi));

        //7. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
        List<WebElement> urunList = driver.findElements(By.xpath("//*[@class='col-sm-4']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(urunList));
        ReusableMethods.bekle(2);

    }
}
