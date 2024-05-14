package Tool.Web;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Tool.Web.Playwrightfactory.Playwrightfactory;
import Tool.Web.listeners.SuiteListeners;
import Tool.Web.listeners.TestListeners;

@Listeners({TestListeners.class,SuiteListeners.class})
public class Base  {

	  
	  Playwright playwright;
	  Page page;
	  Playwrightfactory pl= Playwrightfactory.getinstance();

		/*
		 * @BeforeSuite(alwaysRun = true) public void onStart() {
		 * 
		 * System.out.println("########Before-Suite##########"); }
		 */
	  
}
