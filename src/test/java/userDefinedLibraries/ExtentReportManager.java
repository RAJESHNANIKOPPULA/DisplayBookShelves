package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/***********************************************************************************
*                                                                                  *
* Class Name     : ExtentReportManager                                             * 
* Description    : To Create the extent report file and store that as html file.   *
*                                                                                  *
************************************************************************************/

public class ExtentReportManager {

	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {

			// currentTimeMillis() to prevent overwriting of reports for pass and fail
			String reportName = System.currentTimeMillis() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./reports/extent" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			
		}

		return report;
	}

}