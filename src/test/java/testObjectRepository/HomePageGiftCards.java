package testObjectRepository;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-06-2023           *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***********************************************************************************
*                                                                                  *
* Class Name     : HomePageGiftCards                                               * 
* Description    : To Get all the web elements present in the website              *
* 				   and to return the same.                                         *
************************************************************************************/

public class HomePageGiftCards {

	public static WebElement element = null;
	public static WebDriver driver;
	
	
	//to close the popup
	public static WebElement closePopup(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//div[@class='icofont-cross'])[1]"));
		return element;
		
	}
	
	//click on gift card menu
	public static WebElement giftCardMenu(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//*[contains(text(),'Gift Cards')])[1]"));
		return element;
		
	}
	
	//select birthday or anniversary
	public static WebElement birthDayOrAnniversary(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//h3[contains(text(),'Birthday')]"));
		return element;
		
	}
	
	//total amount for the gift
	public static WebElement findingAmount(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//input[@placeholder='Amount']"));
		return element;
		
	}
	
	//click on next
	public static WebElement nextButton(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//button[text()='Next']"));
		return element;
		
	}
	
	//add reciepent name
	public static WebElement recepientName(WebDriver driver) {
		
		element = driver.findElement(By.name("recipient_name"));
		return element;
		
	}
	
	//add reciepent email
	public static WebElement recepientEmail(WebDriver driver) {
		
		element = driver.findElement(By.name("recipient_email"));
		return element;
		
	}
	
	//add customer name
	public static WebElement customerName(WebDriver driver) {
		
		element = driver.findElement(By.name("customer_name"));
		return element;
		
	}
	
	//add customer email
	public static WebElement customerEmail(WebDriver driver) {
		
		element = driver.findElement(By.name("customer_email"));
		return element;
		
	}
	
	//add customer mobile number
	public static WebElement customerMobileNumber(WebDriver driver) {
		
		element = driver.findElement(By.name("customer_mobile_number"));
		return element;
		
	}
	
	//add special message
	public static WebElement optionalMessage(WebDriver driver) {
		
		element = driver.findElement(By.name("message"));
		return element;
		
	}
	
	//click on confirm button
	public static WebElement confirmButton(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//button[text()='Confirm']"));
		return element;
		
	}
	
}
