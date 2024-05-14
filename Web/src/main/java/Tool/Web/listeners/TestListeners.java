package Tool.Web.listeners;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import Tool.Web.Playwrightfactory.Playwrightfactory;
import Tool.Web.Reporter.ExtentTests;

public class TestListeners implements ITestListener {
	 static Playwrightfactory playwright= Playwrightfactory.getinstance();
	    static String snappath=null;
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println(("*** Running test method " + result.getMethod().getDescription()+ "..."));
        ExtentTests.startTest(result.getMethod().getMethodName());
        ExtentTests.gettest().assignCategory(result.getMethod().getRealClass().getSimpleName());
		
	}
	@Override
	public void onTestSuccess(ITestResult test)
	{
		ExtentTests.endtest();
		
	}
	
	@Override
	public void onTestFailure(ITestResult test)
	{
		ExtentTests.gettest().log(LogStatus.FAIL,"Failed.....");
		ExtentTests.endtest();
	}
	
	@Override
	public void onTestSkipped(ITestResult test)
	{
		
	}
	
	@Override
	public void onStart(ITestContext test)
	{
		
		
	}
	
	@Override
	public void onFinish(ITestContext test)
	{
		
		 ExtentTests.endtest();
		 ExtentTests.endTest();
	}
	
	
}
