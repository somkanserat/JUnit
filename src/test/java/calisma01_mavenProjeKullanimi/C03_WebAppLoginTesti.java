package calisma01_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_WebAppLoginTesti {

    public static void main(String[] args) {
        //1. http://zero.webappsecurity.com
        //    sayfasina gidin
        //2. Signin buttonuna tiklayin
        //3. Login alanine  “username” yazdirin
        //4. Password alanina “password” yazdirin
        //5. Sign in buttonuna tiklayin
        //6. Back tusu ile sayfaya donun
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //9. tarih kismina “2023-09-10” yazdirin
        //10. Pay buttonuna tiklayin
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        //***** 1. http://zero.webappsecurity.com sayfasina gidin *****

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://zero.webappsecurity.com");

        //***** 2. Signin buttonuna tiklayin *****

        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();
            //signIn butonunu bulduk ve tıkladık

        //***** 3. Login alanine  “username” yazdirin *****

        WebElement loginKutusu = driver.findElement(By.id("user_login"));
            //incele yapıldığında user_login 3 adet çıkıyor fakat id'li 1 tane user_login bulunmakta
        loginKutusu.sendKeys("username"); // loginKutusuna "username" yazdık.
        ReusableMethods.bekle(1);

        //***** 4. Password alanina “password” yazdirin *****
        WebElement passwordKutusu = driver.findElement(By.xpath("//*[@id='user_password']"));
            // bu sefer By.id yerine By.xpath kullandık.
        passwordKutusu.sendKeys("password"); // passwordKutusuna "password" yazdık.
        ReusableMethods.bekle(1);

        //***** 5. Sign in buttonuna tiklayin *****
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
            // Sing In tuşunu bulduk ve tıkladık.

        //***** 6. Back tusu ile sayfaya donun *****
        driver.navigate().back();

        //***** 7. Online Banking menusunden Pay Bills sayfasina gidin *****
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
            //önce 'Online Baking' menusune
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
            //daha sonra da 'Pay Bills' menüsüne gittik

        //*****8. amount kismina yatirmak istediginiz herhangi bir miktari yazin*****
        WebElement amountKutusu = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amountKutusu.sendKeys("1200");
        ReusableMethods.bekle(1);

        //***** 9. tarih kismina “2023-09-10” yazdirin *****
        WebElement tarihKutusu = driver.findElement(By.xpath("//*[@id='sp_date']"));
        tarihKutusu.sendKeys("2023-09-10");
        ReusableMethods.bekle(1);

        //***** 10. Pay buttonuna tiklayin *****
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();

        //***** 11. “The payment was successfully submitted.” mesajinin ciktigini test edin *****
        WebElement alertMesajElementi = driver.findElement(By.xpath("//*[@id='alert_content']"));

        String expectedMesaj =  "The payment was successfully submitted.";
        String actualMesaj = alertMesajElementi.getText();

        if (actualMesaj.equals(expectedMesaj)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        ReusableMethods.bekle(1);
        driver.quit();
    }
}
