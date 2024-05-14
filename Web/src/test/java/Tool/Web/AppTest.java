package Tool.Web;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.relevantcodes.extentreports.LogStatus;

import Tool.Web.Playwrightfactory.Playwrightfactory;
import Tool.Web.Reporter.ExtentTests;

/**
 * Unit test for simple App.
 */
public class AppTest  extends Base
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
  
	Page page= pl.init();
	page.navigate("https://google.com");
    ExtentTests.gettest().log(LogStatus.PASS, "esting");
	Playwrightfactory.getplaywright().close();
	System.out.println("Testing...");

    }
}
