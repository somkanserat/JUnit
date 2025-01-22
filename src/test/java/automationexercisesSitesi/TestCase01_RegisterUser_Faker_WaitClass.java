package automationexercisesSitesi;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class TestCase01_RegisterUser_Faker_WaitClass extends TestBaseEach {

    /*
            1. Navigate to url 'http://automationexercise.com'
            2. Verify that home page is visible successfully
            3. Click on 'Signup / Login' button
            4. Verify 'New User Signup!' is visible
            5. Enter name and email address
            6. Click 'Signup' button
            7. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            8. Fill details: Title, Name, Email, Password, Date of birth
            9. Select checkbox 'Sign up for our newsletter!'
            10. Select checkbox 'Receive special offers from our partners!'
            11. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            12. Click 'Create Account button'
            13. Verify that 'ACCOUNT CREATED!' is visible
            14. Click 'Continue' button
            15. Verify that 'Logged in as username' is visible
            16. Click 'Delete Account' button
            17. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         */
    @Test
    public void test01(){

        //1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //2. Verify that home page is visible successfully
            //sayfa başlığının kontrol edilebilir
        String expectedSayfaBaslik = "Automation Exercise";
        String actualSayfaBaslik = driver.getTitle();

        Assertions.assertTrue(actualSayfaBaslik.contains(expectedSayfaBaslik));

        //3. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        ReusableMethods.bekle(1);

        //4. Verify 'New User Signup!' is visible
        WebElement newUserSignupYazisi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(newUserSignupYazisi)); // ExpectedConditions... = Beklenilen koşulu ifade ederiz.
                                                                          // visibilityOf --> görünülebilirlik
        /*
            2:YOL
            WebElement newUserSignupText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New User Signup!']"))
            );
         */

        //5. Enter name and email address
        Faker faker = new Faker(); // sahte isimler kullanmak için faker class'ından yardım alırız.
        Actions actions = new Actions(driver);

        WebElement newUserNameKutusu = driver.findElement(By.xpath("//*[@placeholder='Name']"));
        String name = faker.name().firstName();
        actions.click(newUserNameKutusu).sendKeys(name).perform(); //aşağıdaki işlem ile aynı
        /*
            2.YOL
            newUserNameKutusu.click();
            newUserNameKutusu.sendKeys(faker.name().firstName());
        */

        WebElement newUserEmailKutusu = driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]"));
        String email = faker.internet().emailAddress();
        actions.click(newUserEmailKutusu).sendKeys(email).perform();

        /*
            2.YOL
            newUserEmailKutusu.click();
            newUserEmailKutusu.sendKeys(faker.internet().emailAddress());
        */
        ReusableMethods.bekle(2);

        //6. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        ReusableMethods.bekle(2);

        //7. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationYazisi = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        wait.until(ExpectedConditions.visibilityOf(enterAccountInformationYazisi));

        //8. Fill details: Title, Name, Email, Password, Date of birth
            //cinsiyet
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        ReusableMethods.bekle(1);

            //name --> signUp sayfasında girilen name'in, account sayfasında da aynı olduğunu test ettik.
        WebElement accountNameKutusu = driver.findElement(By.xpath("//*[@id='name']"));
        Assertions.assertEquals(accountNameKutusu.getAttribute("value"), name);

            //email --> signUp sayfasında girilen e-mail'in, account sayfasında da aynı olduğunu test ettik.
        WebElement accountEmailKutusu = driver.findElement(By.xpath("//*[@id='email']"));
        Assertions.assertEquals(accountEmailKutusu.getAttribute("value"),email);
        ReusableMethods.bekle(2);

            //password
        WebElement accountPasswordKutusu = driver.findElement(By.xpath("//*[@id='password']"));
        actions.click(accountPasswordKutusu).sendKeys(faker.internet().password()).perform();
        ReusableMethods.bekle(3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

            //Date of Birth
        WebElement dayDdm = driver.findElement(By.xpath("//*[@id='days']"));
        Select selectDay = new Select(dayDdm);
        selectDay.selectByValue("5");

        WebElement monthDdm = driver.findElement(By.xpath("//*[@id='months']"));
        Select selectMonth = new Select(monthDdm);
        selectMonth.selectByVisibleText("May");

        WebElement yearDdm = driver.findElement(By.xpath("//*[@id='years']"));
        Select selectYear = new Select(yearDdm);
        selectYear.selectByValue("2000");
        ReusableMethods.bekle(3);

        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(faker.address().countryCode());
        ReusableMethods.bekle(3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        WebElement countryKutusu = driver.findElement(By.xpath("//*[@id='country']"));
        Select selectCountry = new Select(countryKutusu);
        selectCountry.selectByValue("Canada");


        driver.findElement(By.xpath("//*[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys(faker.address().cityName());
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys(faker.phoneNumber().phoneNumber());
        ReusableMethods.bekle(2);

        //12. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();



    }
}
