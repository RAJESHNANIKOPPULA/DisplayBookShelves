package testObjectRepository;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-06-2022           *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***********************************************************************************
*                                                                                  *
* Class Name     : HomePageByAtHome                                                * 
* Description    : To Get all the web elements present in the website              *
* 				   and to return the same.                                         *
*                                                                                  *
************************************************************************************/

public class HomePageByAtHome {

	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> bookshelves = null;
	public static List<WebElement> price = null;
	
	//on the given options click option brand
	public static WebElement brandFilter(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[4]"));
		return element;
		
	}
	
	//click on by @ home
	public static WebElement byAtHomeAsBrand(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[4]/div[2]/div/div/div/ul/li[7]"));
		return element;
		
	}
	
	//display the list of all bookshelves
	public static List<WebElement> bookshelvesOfByAtHome(WebDriver driver) {
		
		bookshelves = driver.findElements(By.xpath("//div[contains(text(),'home')]/../../span"));
		return bookshelves;
		
	}
	
	//dislay price of all bookshelves under by @ home
	public static List<WebElement> priceOfByAtHome(WebDriver driver) {
		
		price = driver.findElements(By.xpath("//div[contains(text(),'home')]/../../following-sibling::div[1]/span"));
		return price;
		
	}
	
}
