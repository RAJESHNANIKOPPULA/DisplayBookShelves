package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/***********************************************************************************
*                                                                                  *
* Class Name     : DriverSetup                                                     * 
* Description    : To Create and Start the web driver and also Get the URL to test.*
* 				   Also to close the driver.                                       *
*                                                                                  *
************************************************************************************/

public class DriverSetup {

	static WebDriver driver;
	public static String exePath;
	public static String browserName;
	public static String baseUrl1;
	
	 public static WebDriver openDriver(String browser, String baseUrl) {
		
		 browserName = browser;
		 baseUrl1 = baseUrl;

		if (browserName.equalsIgnoreCase("Edge")) {
			
			//exePath = "C:\\Users\\2271459\\Downloads\\edgedriver_win64\\msedgedriver.exe";
			//System.setProperty("webdriver.edge.driver", exePath);
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
			
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			
			//exePath ="\"C:\\Users\\2271459\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe\"";
			//System.setProperty("webdriver.chrome.driver", exePath);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else {
			
			System.out.println("Not a valid browser");
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
		}
	 
	 public static void closeDriver() {
		 
		 driver.close();
		 
	 }
}
