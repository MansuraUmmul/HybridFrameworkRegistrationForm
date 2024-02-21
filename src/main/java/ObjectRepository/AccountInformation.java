package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountInformation {
    WebDriver driver;

    // Constructor
    public AccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    @Test(dataProvider = "dp")
    public void account_info(String fname, String lname, String eml, String phn, String add1, String add2, String cty,
            String sta, String zp, String cntry) {
        driver.findElement(By.name("account.firstName")).sendKeys(fname);
        driver.findElement(By.name("account.lastName")).sendKeys(lname);
        driver.findElement(By.name("account.email")).sendKeys(eml);
        driver.findElement(By.name("account.phone")).sendKeys(phn);
        driver.findElement(By.name("account.address1")).sendKeys(add1);
        driver.findElement(By.name("account.address2")).sendKeys(add2);
        driver.findElement(By.name("account.city")).sendKeys(cty);
        driver.findElement(By.name("account.state")).sendKeys(sta);
        driver.findElement(By.name("account.zip")).sendKeys(zp);
        driver.findElement(By.name("account.country")).sendKeys(cntry);
    }

    @DataProvider(name = "dp")
    public static Object[][] acc_info_Data() {
        Object[][] data1 = { 
            { "First", "Last", "abc@gmail.com", "012345", "Rd no:22", "Apartment:2c", "NYC", "New York", "1234", "USA", } 
        };

        return data1;
    }
}
