package co.browserCheck;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserChecking {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browserName")
	public void setUpBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"Drivers//chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"Drivers//iedriver.exe");
			driver=new InternetExplorerDriver();
		}else {
			
			System.out.println("you are not using a valid browser");
		}
		
	}
	
	@Test
	public void login()
	{
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	public void tearDown() 
	{
		driver.close();
	}

}