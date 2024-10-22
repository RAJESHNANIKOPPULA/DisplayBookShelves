package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**************************************************************************************
 *                                                                                    *
 * Class Name     : ScreenShot                                                        * 
 * Description    : To Take the screenshots and Copy the .png file into work path.    *
 *                                                                                    *
 **************************************************************************************/

public class ScreenShot {

	public static int flag = 1;

	public static String screenShotTestCase(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screenshot/Message - " + flag + ".png");

		try {

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {

			e.printStackTrace();
		}

		flag++;
		
		return dest.getPath();

	}
	
}
