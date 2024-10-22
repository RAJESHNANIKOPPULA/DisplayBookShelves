package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/***********************************************************************************
*                                                                                  *
* Class Name     : FailReport                                                      * 
* Description    : To Report the failed test cases in the extent report.           *
*                                                                                  *
************************************************************************************/

public class FailReport {
	
	public static WebDriver driver;
	public ExtentReports report;
	public static ExtentTest logger;
	public static String path;

	public static void reportFail(String reportString) {
		
		logger.log(Status.FAIL, reportString);
		
		path = ScreenShot.screenShotTestCase(driver);
		
		try {
			
			logger.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
