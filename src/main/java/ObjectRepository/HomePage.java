package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	WebDriver driver;
	By sign_in=By.xpath("//a[normalize-space()='Sign In']");
	
	//Constructor
	 public HomePage(WebDriver driver) {
		 super(driver);
	    }
	
	
	
	public void sign_in()
	{
		driver.findElement(sign_in).click();
	}

}
