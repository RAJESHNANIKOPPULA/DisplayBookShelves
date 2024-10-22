package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.util.Properties;

/***********************************************************************************
*                                                                                  *
* Class Name     : PropertiesRead                                                  * 
* Description    : To Read the PROPERTIES file.                                    *
*                                                                                  *
************************************************************************************/

public class PropertiesRead {

	public static Properties prop= PropertiesLoad.readPropertiesFile();
    
	public static  String getUrl() {
		
		return prop.getProperty("url");
		
	}
	
	public static String getBrowser() {
		
		return prop.getProperty("browser");
		
	}
	
}
