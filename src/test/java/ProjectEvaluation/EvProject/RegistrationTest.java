package ProjectEvaluation.EvProject;

import java.io.IOException;
import Utilities.CrossBrowserTest;
import Utilities.ExcelData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import ObjectRepository.AccountInformation;
import ObjectRepository.HomePage;
import ObjectRepository.LogInPage;
import ObjectRepository.ProfileInformation;
import ObjectRepository.UserInformation;
import ObjectRepository.regValidation;

public class RegistrationTest 
{   
    WebDriver driver;
    String data[];
    ExtentReports report;
    ExtentTest test;
    
    @BeforeClass
    (groups= {"Function Test", "Smoke Test", "Regression Test"})
    public void setUp() {  
    	
        System.out.println("Setup Before Class");
        report = new ExtentReports();
        ExtentSparkReporter sparkreporter = new ExtentSparkReporter("C:\\Users\\mummu\\eclipse-workspace\\PageObjectModelProject\\target\\evreports.html");
        test = report.createTest("Login Application");
        report.attachReporter(sparkreporter);
        data = new String[2];
    }
    
    @AfterClass
    (groups= {"Function Test", "Smoke Test", "Regression Test"})
    public void tearDown() {        
        
        report.flush();
        driver.quit();
    }
    
    @Test(priority = 1, groups= {"Function Test", "Smoke Test", "Regression Test"})
    public void launchBrowser() throws IOException {
        
        CrossBrowserTest br = new CrossBrowserTest();            
        driver = br.browserInitiate();
        test.log(Status.PASS, "User has launched the Browser");
    }
    
    @Test(priority = 2, groups= {"Function Test", "Smoke Test", "Regression Test"})
    public void signIn() {
        
        HomePage hpg = new HomePage(driver);
        hpg.sign_in();
        test.log(Status.PASS, "User has clicked on 'sign in' button");
    }
    
    @Test(priority = 3, groups= {"Function Test", "Smoke Test", "Regression Test"})
    public void registerNow() {
        
        LogInPage lgn = new LogInPage(driver);
        lgn.reg_btn();
        test.log(Status.PASS, "User has clicked on 'Register Now' button");
    }
    
    @Test(priority = 4, groups= {"Function Test", "Smoke Test"})
    public void fillUserInformation() throws IOException {
        
        ExcelData excelData = new ExcelData();
        String[] userData = excelData.readExcel();
        String userid = userData[0];
        String newpassword = userData[1];
        String rptpassword = userData[2];
        UserInformation userinfo = new UserInformation(driver);
        userinfo.reg_profile_info(userid, newpassword, rptpassword); 
        test.log(Status.PASS, "User has successfully filled the 'User Information' section");
    }
    
    @Test(priority = 5, groups= {"Function Test","Smoke Test"})
    public void fillProfileInformation() {
        
        ProfileInformation pinfo = new ProfileInformation(driver);
        pinfo.prof_info(); 
        test.log(Status.PASS, "User has successfully filled the 'Profile Information' section");
    }
    
    @Test(priority = 6, groups= {"Function Test", "Regression Test"})
    public void fillAccountInformation() {
        
        AccountInformation accountInfo = new AccountInformation(driver);            
        accountInfo.account_info("First", "Last", "abc@gmail.com", "012345", "Rd no:22", "Apartment:2c", "NYC", "New York", "1234", "USA");
        test.log(Status.PASS, "User has successfully filled the 'Account Information' section");
    }
    
    @Test(priority = 7, groups= {"Function Test", "Smoke Test", "Regression Test"})
    public void validateRegistration() throws InterruptedException, IOException {
        
        regValidation valreg = new regValidation(driver);
        valreg.reg_valid();
        String currentUrl = driver.getCurrentUrl();  
	    Assert.assertEquals(currentUrl, "https://petstore.octoperf.com/actions/Account.action");
        test.log(Status.PASS, "User has clicked on the 'Save Account Information' button, redirected to a 'Broken Link'");
    }
    @Test(priority = 8, groups= {"Function Test"})
    public void takescreenshot() throws InterruptedException, IOException {
        
        regValidation valreg = new regValidation(driver);
        valreg.scrn_sht();
        test.log(Status.PASS, "captured the screenshot");
    }
    
}
