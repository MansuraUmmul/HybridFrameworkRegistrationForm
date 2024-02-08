package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInformation {
WebDriver driver;
	
	By user_id=By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/input[1]");
	By new_password=By.xpath("//input[@name='password']");
	By rpt_password=By.xpath("//input[@name='repeatedPassword']");
	
	//Constructor
		public UserInformation(WebDriver driver)
		{
			this.driver=driver;
		}
	
	
	public void reg_profile_info(String u1, String p1, String p2)
	{
		driver.findElement(user_id).sendKeys(u1);
		driver.findElement(new_password).sendKeys(p1);
		driver.findElement(rpt_password).sendKeys(p2);
		
	}
	
	

}