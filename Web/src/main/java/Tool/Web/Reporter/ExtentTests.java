package Tool.Web.Reporter;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTests {
	
//public static	ThreadLocal<ExtentTest> ext= new ThreadLocal();
	
	static ExtentReports extent= ExtentManager.getInstance();
	
static Map<Integer, ExtentTest> ext = new HashMap<Integer, ExtentTest>();
	  public static synchronized ExtentTest startTest(String testName) {
	        ExtentTest test = extent.startTest(testName);
	        ext.put((int) (long) (Thread.currentThread().getId()), test);
	        return test;
	    }
	  public static ExtentTest gettest()
	  {
		  return (ExtentTest) ext.get((int) (long) (Thread.currentThread().getId()));
	  }

	  public static synchronized  void endtest()
	    {
	        extent.endTest(gettest());
	    }
	    public static synchronized void endTest() {
	        extent.flush();
	    }
}
