package calisma04_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseEach;


public class C06_AyniWindowdaGezinme extends TestBaseEach {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        //windowhandle degerini ve url'i yazdirin
        System.out.println("Anasayfa url:" +driver.getCurrentUrl());
        System.out.println("Anasayfa whd:" +driver.getWindowHandles());

        //Electronics linkini tiklayin
        driver.findElement(By.xpath("//*[@href='https://www.testotomasyonu.com/category/7/products']")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics url:" +driver.getCurrentUrl());
        System.out.println("Electronics whd:" +driver.getWindowHandles());

        //ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='prod-title mb-3 '])[1]"));

        // windowhandle degerini ve url'i yazdirin
        System.out.println("İlk ürün url:" +driver.getCurrentUrl());
        System.out.println("İlk ürün whd:" +driver.getWindowHandles());

        // account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("account url : " + driver.getCurrentUrl());
        System.out.println("account whd : " + driver.getWindowHandle());

    }
}
