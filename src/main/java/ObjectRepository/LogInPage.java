package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	WebDriver driver;
	
	By register_now=By.xpath("//a[normalize-space()='Register Now!']");
	
	
	//Constructor
	 public LogInPage(WebDriver driver) {
	        this.driver=driver;
	    }
	
	
	public void reg_btn()
	{
		driver.findElement(register_now).click();
	}
}
		
	
	

