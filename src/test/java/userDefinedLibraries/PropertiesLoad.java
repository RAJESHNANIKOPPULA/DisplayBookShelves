package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/***********************************************************************************
*                                                                                  *
* Class Name     : PropertiesLoad                                                  * 
* Description    : To Load the PROPERTIES file from the desired location.          *
*                                                                                  *
************************************************************************************/

public class PropertiesLoad {
	
	public  static Properties readPropertiesFile() 
	{
		
        FileInputStream fis = null;
        
        try {
        	
        	String filePath="./src/test/java/dataTables/Config.properties";
            fis = new FileInputStream(filePath);
            
        } catch (FileNotFoundException e) {
        	
        	e.printStackTrace();
        	
        }
        
        Properties prop = new Properties();
        
        try {
        	
            prop.load(fis);
            
        } catch (IOException e) {
        	
        	e.printStackTrace();
        	
        }
        
        return prop;
        
	}
	
}
