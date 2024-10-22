package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/***********************************************************************************
*                                                                                  *
* Class Name     : RetryListener                                                   * 
* Description    : To Retry the failed test cases.                                 *
*                                                                                  *
************************************************************************************/

public class RetryListener implements IAnnotationTransformer {

    @SuppressWarnings("rawtypes")
    public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
            Method testMethod) {
        Class retry = testannotation.getRetryAnalyzerClass();
        if (retry == null) {
            testannotation.setRetryAnalyzer(RetryFailedTestCases.class);
        }

    }

}