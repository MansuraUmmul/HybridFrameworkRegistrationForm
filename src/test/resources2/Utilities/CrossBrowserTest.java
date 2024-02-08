package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
	
	  WebDriver driver;
	    String filePath="C:\\Users\\mummu\\eclipse-workspace\\Selenium_webdrivr_maven\\config.properties";

	    public WebDriver browserInitiate() throws IOException {
	    	
	    	//step1:
	    	FileInputStream fis=new FileInputStream(filePath);
	    	
	    	//step2:
	    	Properties p=new Properties();
	    	
	    	//step3
	    	p.load(fis);    	
			String browserName=p.getProperty("browser");
	        switch (browserName) {
	            case "chrome":
	                driver = new ChromeDriver();
	                driver.get(p.getProperty("url"));                
	                break;

	            case "edge":
	                driver = new EdgeDriver();
	                driver.get(p.getProperty("url"));
	                break;  
	                
	            case "firefox":
	                driver = new FirefoxDriver();
	                driver.get(p.getProperty("url"));
	                break;

	            default:
	                System.out.println("Invalid browser name");
	                break;
	        }
	    
	return driver;
	}
	}


