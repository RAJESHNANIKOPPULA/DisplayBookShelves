package testObjectRepository;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-06-2023           *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***********************************************************************************
*                                                                                  *
* Class Name     : HomePageBookShelves                                             * 
* Description    : To Get all the web elements present in the website              *
* 				   and to return the same.                                         *
*                                                                                  *
************************************************************************************/

public class HomePageBookShelves {

	public static WebElement element = null;
	public static List<WebElement> bookshelves = null;
	public static List<WebElement> price = null;
	public static WebDriver driver;
	
	
	
	public static WebElement bookShelves (WebDriver driver) {
		
		element = driver.findElement(By.xpath("//h4[text()='Bookshelves']/.."));
		return element;
		
	}
	
	public static WebElement checkSignUp(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']"));
		return element;
		
	}
	//filtering name of bookshelves accrding to price
	public static WebElement priceFilter(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//li[@data-group='price' and @class='item']"));
		return element;
		
	}
	//In the drag drop menu check limit of the price
	public static WebElement dragAndDropOfPrice(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
		return element;
		
	}
	//selecting storage type of bookshelves
	public static WebElement strogeFilter(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//li[@data-group='storage type' and @class='item']"));
		return element;
		
	}
	//selecting storage type as open
	public static WebElement openOfStroge(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//input[@type='checkbox' and @value='Open']"));
		return element;
		
	}
	//click excluding out of stock check Box
	public static WebElement excludingOutOfStock(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//input[@value='In Stock Only']"));
		return element;
		
	}
	//to get the name of Bookshelves
	public static List<WebElement> nameOfBookShelves(WebDriver driver){
		
		bookshelves = driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/ul/li/div/div[5]/a/div[1]/span"));
		return bookshelves;
		
	}
	//to get price  of all bookshelves listed
	public static List<WebElement> priceOfBookShelves(WebDriver driver) {
		
		price = driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/ul/li/div/div[5]/a/div[2]/span"));
		return price;
		
	}
	
}
