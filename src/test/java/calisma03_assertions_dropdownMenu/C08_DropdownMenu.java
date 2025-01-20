package calisma03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_DropdownMenu extends TestBaseEach {
    /*
        1. http://zero.webappsecurity.com/ Adresine gidin
        2. Sign in butonuna basin
        3. Login kutusuna “username” yazin
        4. Password kutusuna “password” yazin
        5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        6. Online banking menusunden Pay Bills sayfasina gidin
        7. “Purchase Foreign Currency” tusuna basin
        8. “Currency” drop down menusunden Eurozone’u secin
        9. “amount” kutusuna bir sayi girin
        10. “US Dollars” in secilmedigini test edin
        11. “Selected currency” butonunu secin
        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */

    @Test
    public void test01(){

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        ReusableMethods.bekle(1);

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        ReusableMethods.bekle(2);

        //3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.xpath("//*[@id='user_login']"));
        loginKutusu.sendKeys("username");

        //4. Password kutusuna “password” yazin
        WebElement passwordKutusu = driver.findElement(By.xpath("//*[@id='user_password']"));
        passwordKutusu.sendKeys("password");
        ReusableMethods.bekle(1);

        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();
        ReusableMethods.bekle(1);

        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        ReusableMethods.bekle(1);

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[@href='#ui-tabs-3']")).click();
        ReusableMethods.bekle(1);

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByValue("EUR");
        ReusableMethods.bekle(1);

        // 9. “amount” kutusuna bir sayi girin
        WebElement amountKutusu = driver.findElement(By.xpath("//*[@id='pc_amount']"));
        amountKutusu.sendKeys("250");
        ReusableMethods.bekle(1);

        // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollarsCheckBox = driver.findElement(By.xpath("//*[@id='pc_inDollars_true']"));
        Assertions.assertFalse(usDollarsCheckBox.isSelected(),"US Dollars Checkbox seçili");
        ReusableMethods.bekle(1);

        // 11. “Selected currency” butonunu secin
        WebElement selectedCurrencyCheckBox = driver.findElement(By.xpath("//*[@id='pc_inDollars_false']"));
        selectedCurrencyCheckBox.click();

        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();
        ReusableMethods.bekle(1);

        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement mesajElementi = driver.findElement(By.xpath("//*[@id='alert_content']"));

        String expectedMessage = "Foreign currency cash was successfully purchased.";
        String actualMessage = mesajElementi.getText();

        Assertions.assertTrue(expectedMessage.equals(actualMessage),"'Foreign currency cash was successfully purchased.' mesajı çıkmamıştır");

    }
}
