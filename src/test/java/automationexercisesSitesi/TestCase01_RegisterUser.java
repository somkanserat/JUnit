package automationexercisesSitesi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class TestCase01_RegisterUser extends TestBaseEach {

    /*
        1. Tarayıcıyı başlatın
        2. 'http://automationexercise.com' adresine gidin
        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        5. 'New User Signup!'nın görünür olduğunu doğrulayın
        6. Adınızı ve e-posta adresinizi girin
        7. 'Kayıt Ol' düğmesine tıklayın
        8. 'ENTER ACCOUNT INFORMATION'in görünür olduğunu doğrulayın
        9. Ayrıntıları doldurun: Ünvan, Ad, E-posta, Parola, Doğum tarihi
        10. 'Sign up for our newsletter!' onay kutusunu seçin
        11. 'Receive special offers from our partners!' onay kutusunu seçin
        12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
        13. 'Create Account button' düğmesine tıklayın
        14. 'ACCOUNT CREATED!' görünürlülüğünü doğrulayın
        15. 'Continue' düğmesine tıklayın
        16. 'Logged in as username' ifadesinin görünür olduğunu doğrulayın
        17. 'Delete Account' düğmesine tıklayın
        18. 'ACCOUNT DELETED!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesine tıklayın
     */

    @Test
    public void test01(){

        //2. 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
            //sayfa başlığının kontrol edilebilir
        String expectedSayfaBaslik = "Automation Exercise";
        String actualSayfaBaslik = driver.getTitle();

        Assertions.assertTrue(actualSayfaBaslik.contains(expectedSayfaBaslik));

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        ReusableMethods.bekle(1);

        //5. 'New User Signup!'nın görünür olduğunu doğrulayın
        String expectedNewUserSignupYazisi = "New User Signup!";
        String actualNewUserSignupYazisi = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();

        Assertions.assertTrue(actualNewUserSignupYazisi.contains(expectedNewUserSignupYazisi));

        //6. Adınızı ve e-posta adresinizi girin
        ReusableMethods.bekle(1);
        WebElement nameKutusu = driver.findElement(By.xpath("//*[@placeholder='Name']"));
        nameKutusu.sendKeys("Xxxxxx");
        ReusableMethods.bekle(1);

        WebElement emailKutusu = driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]"));
        emailKutusu.sendKeys("xxxxxx@gmail.com");
        ReusableMethods.bekle(1);

        //7. 'Signup' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //8. 'ENTER ACCOUNT INFORMATION'in görünür olduğunu doğrulayın
        String expectedEnterAccountInformationYazisi = "ENTER ACCOUNT INFORMATION";
        String actualEnterAccountInformationYazisi = driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();

        Assertions.assertTrue(actualEnterAccountInformationYazisi.contains(expectedEnterAccountInformationYazisi));
        ReusableMethods.bekle(1);

        //9. Ayrıntıları doldurun: Ünvan, Ad, E-posta, Parola, Doğum tarihi
        WebElement cinsiyetCheckBox = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        cinsiyetCheckBox.click();
        ReusableMethods.bekle(1);

        /*
            String expectedKayitliName = "Xxxxx";
            String actualKayitliName = driver.findElement(By.xpath("//*[@value='Xxxxx']")).getText();

            Assertions.assertTrue(actualKayitliName.equals(expectedKayitliName));

            String expectedKayitliEmail = "xxxxx@gmail.com";
            String actualKayitliEmail = driver.findElement(By.xpath("//*[@value='Xxxxx']")).getText();

            Assertions.assertTrue(actualKayitliEmail.equals(expectedKayitliEmail));
        */
        //şifre gir
        WebElement passwordKutusu = driver.findElement(By.xpath("//*[@id='password']"));
        passwordKutusu.sendKeys("xxxxx");
        ReusableMethods.bekle(1);

        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //day
        WebElement gundDm = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectGun = new Select(gundDm);
        selectGun.selectByValue("20"); //20
        ReusableMethods.bekle(1);

        //month
        WebElement aydDm = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectAy = new Select(aydDm);
        selectAy.selectByValue("1"); //Ocak
        ReusableMethods.bekle(1);

        //year
        WebElement yildDm = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYil = new Select(yildDm);
        selectYil.selectByValue("1998");

        //10. 'Sign up for our newsletter!' onay kutusunu seçin
        WebElement signUpForCheckBox = driver.findElement(By.xpath("//*[@id='newsletter']"));
        signUpForCheckBox.click();
        ReusableMethods.bekle(1);

        //11. 'Receive special offers from our partners!' onay kutusunu seçin
        WebElement receiveSpecialCheckBox = driver.findElement(By.xpath("//*[@id='optin']"));
        receiveSpecialCheckBox.click();
        ReusableMethods.bekle(1);

        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
        WebElement firstNameKutusu = driver.findElement(By.xpath("//*[@id='first_name']"));
        firstNameKutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement lastNameKutusu = driver.findElement(By.xpath("//*[@id='last_name']"));
        lastNameKutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement companyKutusu = driver.findElement(By.xpath("//*[@id='company']"));
        companyKutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement address1Kutusu = driver.findElement(By.xpath("//*[@id='address1']"));
        address1Kutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement address2Kutusu = driver.findElement(By.xpath("//*[@id='address2']"));
        address2Kutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        WebElement countrydDm = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectcountrydDm = new Select(countrydDm);
        selectcountrydDm.selectByValue("United States");

        WebElement stateKutusu = driver.findElement(By.xpath("//*[@id='state']"));
        stateKutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement cityKutusu = driver.findElement(By.xpath("//*[@id='city']"));
        cityKutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement zipcodeKutusu = driver.findElement(By.xpath("//*[@id='zipcode']"));
        zipcodeKutusu.sendKeys("xx");
        ReusableMethods.bekle(1);

        WebElement mobileNumberKutusu = driver.findElement(By.xpath("//*[@id='mobile_number']"));
        mobileNumberKutusu.sendKeys("00");
        ReusableMethods.bekle(1);

        //13. 'Create Account button' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        ReusableMethods.bekle(1);

        //14. 'ACCOUNT CREATED!' görünürlülüğünü doğrulayın
        String expectedAccountCreatedYazisi = "ACCOUNT CREATED!";
        String actualAccountCreatedYazisi = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();

        Assertions.assertTrue(actualAccountCreatedYazisi.contains(expectedAccountCreatedYazisi));

        //15. 'Continue' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        ReusableMethods.bekle(1);

        //16. 'Logged in as username' ifadesinin görünür olduğunu doğrulayın
        String expectedLoggedInAsYazisi = "Logged in as ";
        String actualLoggedInAsYazisi = driver.findElement(By.xpath("//a[text()=' Logged in as ']")).getText();

        Assertions.assertTrue(actualLoggedInAsYazisi.contains(expectedLoggedInAsYazisi));

        //17. 'Delete Account' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        ReusableMethods.bekle(1);

        //18. 'ACCOUNT DELETED!' ifadesinin görünür olduğunu doğrulayın ve 'Continue' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        ReusableMethods.bekle(1);
    }
}
