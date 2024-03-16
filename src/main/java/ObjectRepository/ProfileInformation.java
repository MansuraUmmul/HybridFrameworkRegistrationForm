package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileInformation {
	WebDriver driver;
	
	By my_list=By.xpath("//table[3]/tbody[1]/tr[3]/td[2]/input[1]");
	By my_banner=By.xpath("//table[3]/tbody[1]/tr[4]/td[2]/input[1]");
	
	//Constructor
	public ProfileInformation(WebDriver driver) {
		this.driver=driver;
    }
			
			public void prof_info()
			{
				driver.findElement(my_list).click();
				driver.findElement(my_banner).click();
			}
	
	
	
}


