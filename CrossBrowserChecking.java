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
		
		if(browserName.equalsIgnoreCase("chrome")) {										// Check if parameter passed as chrome
			System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe"); 	// Set path to the chromedriver.exe
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){									// Check if parameter passed as firefox
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");	// Set path to the geckodriver.exe
			driver=new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")){										// Check if parameter passed as edge
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//edgedriver.exe");	// Set path to the edgedriver.exe
			driver=new EdgeDriver();
		}else {
			
			System.out.println("you are not using a valid browser");
		}
		
	}
	
	@Test
	public void login()
	{
		driver.get("https://www.amazon.com/");						// Navigate to the amazon.com website
		driver.manage().window().maximize();						// Maximize the window size
		driver.manage().deleteAllCookies();						// Deleting all the cookies
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		// Set the page load time out - amount of time that Selenium webdriver will wait for a page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		// Set implicit wait -Selenium WebDriver will wait for the element before the exception occurs
		
		
	}
	
	public void tearDown() 
	{
		driver.close();									// Close the window
	}

}
