package ObjectRepository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class regValidation {
	WebDriver driver;
	
	By save_acc=By.xpath("(//input[@name='newAccount'])[1]");
	
	//Constructor
	public regValidation(WebDriver driver) {
		this.driver=driver;
    }
			
	
	public void reg_valid(){
			              
				driver.findElement(save_acc).click();			        
			    
	}
	public void scrn_sht() throws IOException {
		        
		        driver.manage().window().maximize();		
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File trg=new File("C:\\Users\\mummu\\eclipse-workspace\\PageObjectModelProject\\screenshot\\fullpage.png");
				FileUtils.copyFile(src, trg);
			}
	

}
