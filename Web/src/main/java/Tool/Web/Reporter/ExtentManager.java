package Tool.Web.Reporter;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	
	 	
	 	private static ExtentReports extent;
	    private static ExtentTest test;
	    
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	    public static ExtentReports createInstance() {

	        File reportfile= new File(System.getProperty("user.dir")+"/Extent/PlaywrightTest.html");
	        try {
	            if (!reportfile.exists()) {
	                reportfile.createNewFile();

	            }
	        }
	        catch (Exception e)
	        {


	        }
	        extent = new ExtentReports(System.getProperty("user.dir")+"/Extent/PlaywrightTest.html",true);
	        return  extent;

	    }
}
