package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/***********************************************************************************
*                                                                                  *
* Class Name     : JsonRead                                                        * 
* Description    : To Read the JSON file from the desired location.                *
*                                                                                  *
************************************************************************************/

public class JsonRead {

	public static JSONParser parser;
	public static JSONObject jsonObject;
	public static Object obj;
	public static String amount;
	public static String recipientName;
	public static String recipientEmail;
	public static String customerName;
	public static String customerEmail;
	public static String customerMobile;
	public static String message;
	
	public static void readJSONFile() {
		
		try {
			
			parser = new JSONParser();
			obj = parser.parse(new FileReader("./src/test/java/dataTables/GiftCardInput.json"));
	        jsonObject = (JSONObject)obj;
	        
	        amount         = (String)jsonObject.get("Amount");
	        recipientName  = (String)jsonObject.get("Recipient_Name");
	        recipientEmail = (String)jsonObject.get("Recipient_Email");
	        customerName   = (String)jsonObject.get("Customer_Name");
	        customerEmail  = (String)jsonObject.get("Customer_Email");
	        customerMobile = (String)jsonObject.get("Customer_Mobile");
	        message        = (String)jsonObject.get("Message");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	 
	}
	
}
