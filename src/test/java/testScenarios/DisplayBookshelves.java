package testScenarios;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-June-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testObjectRepository.HomePageBookShelves;
import testObjectRepository.HomePageByAtHome;
import testObjectRepository.HomePageGiftCards;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelWrite;
import userDefinedLibraries.ExplicitWait;
import userDefinedLibraries.ExtentReportManager;
import userDefinedLibraries.FailReport;
import userDefinedLibraries.JsonRead;
import userDefinedLibraries.PropertiesRead;
import userDefinedLibraries.ScreenRecorderUtil;
import userDefinedLibraries.ScreenShot;

/***********************************************************************************
*                                                                                  *
* Class Name     : DisplayBookshelves                                              * 
* Description    : To Test the all the test cases.                                 *
*                                                                                  *
************************************************************************************/

public class DisplayBookshelves extends DriverSetup {
	
	public static WebDriver driver;
	public static Actions action;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet = null;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static String[] bookShelves;
	public static String[] prices;
	public static String validationMessage;
	public static String browser;
	public static String baseUrl;
	public static String path;
	
	//to start screen recording
	@BeforeGroups("Smoke Test one")
	public static void screenRecordStart () {
		
		try {
			
			ScreenRecorderUtil.startRecord("Verify Bookshelves");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//configuration of drivers added
	@BeforeGroups("Smoke Test one")
	public static void driverConfig () {
		
		browser = PropertiesRead.getBrowser();
		baseUrl = PropertiesRead.getUrl();
		report = ExtentReportManager.getReportInstance();
		driver = DriverSetup.openDriver(browser, baseUrl);
		
	}
	
	//to read JSON file
	@Test(priority = 0 , groups = { "Smoke Test one" })
	public static void testCaseReadJSON() {
		
		try {
			
			JsonRead.readJSONFile();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//click on bookshelves menu and take log
	@Test(priority = 1 , groups = { "Smoke Test one" })
	public static void clickOnBookShelvesMenu() {
		
		logger = report.createTest("Opening Bookshelves Menu");
		logger.log(Status.INFO, "To open the bookshelves menu item");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		HomePageBookShelves.bookShelves(driver).click();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	////to close the popup which comes 
	@Test(priority = 2 , groups = { "Smoke Test one" })
	public static void closePopUp() {
		
		try {
			
			HomePageBookShelves.checkSignUp(driver).click();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//to move the mouse to the filter button
	@Test(priority = 3 , groups = { "Smoke Test one" })
	public static void mouseHoverToPriceFilter() {
		
		logger = report.createTest("Hovering Mouse to Price Filter");
		logger.log(Status.INFO, "To hover the mouse over the price filter");
		
		action = new Actions(driver);
		action.moveToElement(HomePageBookShelves.priceFilter(driver)).perform();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//waiting for drag and drop
	@Test(priority = 4 , groups = { "Smoke Test one" })
	public static void waitForDragAndDropVisibility() {
		
		logger = report.createTest("Waiting for Drag and Drop Visibility");
		logger.log(Status.INFO, "To wait for the drag and drop of price filter to visible");
		
		ExplicitWait.priceFilterVisibility(driver);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click on drag on drop
	@Test(priority = 5 , groups = { "Smoke Test one" })
	public static void dragAndDropOfPriceFilter() {
		
		logger = report.createTest("Drag and Drop the Price Filter");
		logger.log(Status.INFO, "To perform drag and drop functionality on price filter");
		
		action.moveToElement(HomePageBookShelves.dragAndDropOfPrice(driver)).
			dragAndDropBy(HomePageBookShelves.dragAndDropOfPrice(driver), -202, 0).perform();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	@Test(priority = 6 , groups = { "Smoke Test one" })
	public static void mouseHoverToStrogeTypFilter() {
		
		logger = report.createTest("Hovering Mouse to Stroge Type Filter");
		logger.log(Status.INFO, "To hover the mouse over the storage type filter");
		
		action.moveToElement(HomePageBookShelves.strogeFilter(driver)).perform();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//to click open as storage type
	@Test(priority = 7 , groups = { "Smoke Test one" })
	public static void openAsStorageType() {
		
		logger = report.createTest("Selecting Open as Stroge Type");
		logger.log(Status.INFO, "To select the open type as storage type filter");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", HomePageBookShelves.openOfStroge(driver));
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click on exclude out of stock check box
	@Test(priority = 8 , groups = { "Smoke Test one" })
	public static void enablingExcludeOutOfStock() {
		
		logger = report.createTest("Enabling Out of Stocks");
		logger.log(Status.INFO, "To enable the out of stock checkbox filter");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", HomePageBookShelves.excludingOutOfStock(driver));
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//collecting bookshelves
	@Test(priority = 9 , groups = { "Smoke Test one" })
	public static void collectingBookShelvesList() {
		
		logger = report.createTest("Collecting Bookshelves list and Writing into Excel File");
		logger.log(Status.INFO, "To collect the bookshelves list and write it into excel file");
		
		bookShelves = new String[HomePageBookShelves.nameOfBookShelves(driver).size()];
		prices = new String[HomePageBookShelves.priceOfBookShelves(driver).size()];
		
		for(int i=0; i<HomePageBookShelves.bookshelves.size(); i++) {
			
			bookShelves[i] = HomePageBookShelves.nameOfBookShelves(driver).get(i).getText();
			prices[i] = HomePageBookShelves.priceOfBookShelves(driver).get(i).getText();
			prices[i] = prices[i].replaceAll("[^0-9]", "");
			
		}
		
		ExcelWrite.below15000BookShelves(bookShelves , prices , 3);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//display book shelves
	@Test(priority = 10 , groups = { "Smoke Test one" })
	public static void displayingBookShelves() {
		
		logger = report.createTest("Displaying bookshelves in the Console");
		logger.log(Status.INFO, "To display the bookshelves list in the console");
		
		for(int i=0; i<3; i++) {
			
			System.out.println(bookShelves[i] + " - Rs." + prices[i]);
			
		}
	
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//take screen shot of page
	@Test(priority = 11 , groups = { "Smoke Test one" })
	public static void screenShotOfBookShelves() {
		
		logger = report.createTest("Taking Screenshot of Bookshelves");
		logger.log(Status.INFO, "To capture the screenshot of bookshelves list");
		
		try {
			
			ScreenShot.screenShotTestCase(driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//move mouse pointer to brand option
	@Test(priority = 12 ,groups = { "Regression Test one" })
	public static void mouseHoverOfBrandFilter() {
		
		logger = report.createTest("Hovering Mouse to Brand Filter");
		logger.log(Status.INFO, "To hover the mouse over the brand filter");
		
		action.moveToElement(HomePageByAtHome.brandFilter(driver)).perform();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click on by @ home
	@Test(priority = 13 ,groups = { "Regression Test one" })
	public static void clickOnByAtHomeAsBrand() {
		
		logger = report.createTest("Selecting By@Home option as Brand Filter");
		logger.log(Status.INFO, "To select the By@Home option as brand filter");
		
		HomePageByAtHome.byAtHomeAsBrand(driver).click();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//display the details in console
	@Test(priority = 14 ,groups = { "Regression Test one" })
	public static void byAtHomeBookShelvesList() {
		
		logger = report.createTest("Collecting Bookshelves list of By@Home and Writing into Excel File");
		logger.log(Status.INFO, "To collect the bookshelves list of By@Home and write it into excel file");
		
		bookShelves = new String[HomePageByAtHome.bookshelvesOfByAtHome(driver).size()];
		prices = new String[HomePageByAtHome.priceOfByAtHome(driver).size()];
		
		int x = HomePageByAtHome.bookshelves.size();
		
		for(int i=0; i<x; i++) {
			
			bookShelves[i] = HomePageByAtHome.bookshelvesOfByAtHome(driver).get(i).getText();
			prices[i] = HomePageByAtHome.priceOfByAtHome(driver).get(i).getText();
			prices[i] = prices[i].replaceAll("[^0-9]", "");
			
		}
		
		ExcelWrite.byAtHomeBookshelves(bookShelves , prices , x);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//display the deatils in consle
	@Test(priority = 15 ,groups = { "Regression Test one" })
	public static void displayingByAtHomeBookShelves() {
		
		logger = report.createTest("Displaying bookshelves of By@Home in the Console");
		logger.log(Status.INFO, "To display the bookshelves of By@Home list in the console");
		
		for(int i=0; i<HomePageByAtHome.bookshelvesOfByAtHome(driver).size(); i++) {
			
			System.out.println(bookShelves[i] + " - Rs." + prices[i]);
			
		}
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//take the screenshot of the page
	@Test(priority = 16 ,groups = { "Regression Test one" })
	public static void screenShotOfByAtHomeBookShelves() {
		
		logger = report.createTest("Taking Screenshot of Bookshelves of By@Home");
		logger.log(Status.INFO, "To capture the screenshot of bookshelves list of By@Home");
		
		try {
			
			action.moveToElement(HomePageBookShelves.excludingOutOfStock(driver)).perform();
			ScreenShot.screenShotTestCase(driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//wait for the gift card visibility
	@Test(priority = 17 ,groups = { "Smoke Test two" })
	public static void waitForGiftCardVisibility() {
		
		logger = report.createTest("Waiting for visibility of Gift Cards Menu");
		logger.log(Status.INFO, "To wait for the gift card menu to visible");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
		//HomePageGiftCards.closePopup(driver).click();
		ExplicitWait.giftCardVisibility(driver);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click gift card option
	@Test(priority = 18 ,groups = { "Smoke Test two" })
	public static void clickOnGiftCard() {
		
		logger = report.createTest("Clicking Gift Card Menu");
		logger.log(Status.INFO, "To click on the gift card menu");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", HomePageGiftCards.giftCardMenu(driver));
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click on Birthday or anniversary
	@Test(priority = 19 ,groups = { "Smoke Test two" })
	public static void clickOnBirthdayOrAnniversary() {
		
		logger = report.createTest("Clicking Birthday/Anniversary Sub-Menu");
		logger.log(Status.INFO, "To click on the Birthday/Anniversary sub-menu");
		
		HomePageGiftCards.birthDayOrAnniversary(driver).click();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//displaying the total amount
	@Test(priority = 20 ,groups = { "Smoke Test two" })
	public static void enteringAmount() {
		
		logger = report.createTest("Entering Amount");
		logger.log(Status.INFO, "To enter amount in the field");
		
		HomePageGiftCards.findingAmount(driver).sendKeys(JsonRead.amount);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click on next
	@Test(priority = 21 ,groups = { "Smoke Test two" })
	public static void clickOnNext() {
		
		logger = report.createTest("Clicking on NEXT");
		logger.log(Status.INFO, "To click on the next button");
		
		HomePageGiftCards.nextButton(driver).click();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//to display the recepient name
	@Test(priority = 22 ,groups = { "Smoke Test two" })
	public static void enterRecipientName() {
		
		logger = report.createTest("Entering Receipient's Name");
		logger.log(Status.INFO, "To enter recipient's name");
		
		HomePageGiftCards.recepientName(driver).sendKeys(JsonRead.recipientName);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//to display the recepient email
	@Test(priority = 23 ,groups = { "Smoke Test two" })
	public static void enterRecipientEmail() {
		
		logger = report.createTest("Entering Recipient's Email");
		logger.log(Status.INFO, "To enter recipient's email");
		
		HomePageGiftCards.recepientEmail(driver).sendKeys(JsonRead.recipientEmail);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//to display the customer name
	@Test(priority = 24 ,groups = { "Smoke Test two" })
	public static void enterCustomerName() {
		
		logger = report.createTest("Entering Customer's Name");
		logger.log(Status.INFO, "To enter customer's name");
		
		HomePageGiftCards.customerName(driver).sendKeys(JsonRead.customerName);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//to display the customer email
	@Test(priority = 25 ,groups = { "Smoke Test two" })
	public static void enterCustomerEmail() {
		
		logger = report.createTest("Entering Customer's Email");
		logger.log(Status.INFO, "To enter customer's email");
		
		HomePageGiftCards.customerEmail(driver).sendKeys(JsonRead.customerEmail);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//to display the customer mobile number
	@Test(priority = 26 ,groups = { "Smoke Test two" })
	public static void enterCustomerMobileNumber() {
		
		logger = report.createTest("Entering Customer's Mobile Number");
		logger.log(Status.INFO, "To enter customer's mobile number");
		
		HomePageGiftCards.customerMobileNumber(driver).sendKeys(JsonRead.customerMobile);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//enter the special message
	@Test(priority = 27 ,groups = { "Smoke Test two" })
	public static void enterMessage() {
		
		logger = report.createTest("Entering Message");
		logger.log(Status.INFO, "To enter message");
		
		HomePageGiftCards.optionalMessage(driver).sendKeys(JsonRead.message);
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//click on confirm
	@Test(priority = 28 ,groups = { "Smoke Test two" })
	public static void clickOnConfirm() {
		
		logger = report.createTest("Clicking On CONFIRM Button");
		logger.log(Status.INFO, "To click on confirm button");
		
		HomePageGiftCards.confirmButton(driver).click();
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//take the screen of error message
	@Test(priority = 29 ,groups = { "Smoke Test two" })
	public static void screenShotOfErrorMessage() {
		
		logger = report.createTest("Taking Screenshot of Error Message");
		logger.log(Status.INFO, "To capture the screenshot of error message displayeg on the web page");
		
		try {
			
			ScreenShot.screenShotTestCase(driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		logger.log(Status.PASS, "PASSED");
		
	}
	
	//display error message in console
	@Test(priority = 30 ,groups = { "Smoke Test two" })
	public static void displayErrorMessage() {
		
		logger = report.createTest("Displaying Error Message in the Console");
		logger.log(Status.INFO, "To display the error message in the console");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", HomePageGiftCards.recepientEmail(driver));
	    System.out.println(validationMessage);
	    
	    logger.log(Status.PASS, "PASSED");
	    
	}
	
	//log the status as success or failed
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
		
			logger.log(Status.FAIL, "Failed");
			path = ScreenShot.screenShotTestCase(driver);
			
			try {
				
				logger.addScreenCaptureFromPath(path);
				
			} catch (Exception e) {
				
				FailReport.reportFail(e.getMessage());
				
			}
			
		}
		
	}
	
	//close the browser
	@AfterGroups("Smoke Test two")
	public static void closingBrowser () {
		
		report.flush();
		DriverSetup.closeDriver();
		
	}
	
	//stop screen recording
	@AfterGroups("Smoke Test two")
	public static void screenRecordStop () {
		
		try {
			
			ScreenRecorderUtil.stopRecord();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
