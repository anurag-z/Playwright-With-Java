package Tool.Web;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.*;

import Tool.Web.Playwrightfactory.Playwrightfactory;

/**
 * Hello world!
 *
 */
public class App 
{ 
	Playwright playwright;
	
	public void navigate() throws Throwable
	{
		playwright= Playwright.create();
		
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1536,703));
		Page page= context.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
			page.waitForLoadState();
		page.locator("#myFile").scrollIntoViewIfNeeded();
		Thread.sleep(3000);
		page.fill("#pizza", "pizza");
		page.fill("#kils", "kils");
		page.setInputFiles("#myFile", Paths.get("pom.xml"));
		Thread.sleep(2000);
		page.setInputFiles("#myFile", new Path[0]);
		page.hover("button:has-text('Checkout here')");
		List<String>ls= page.locator("div.dropdown-content").allInnerTexts();
		ls.forEach(e->System.out.println(e));
		Locator result= page.locator("#resultTable tr");
		result.locator(":scope",new Locator.LocatorOptions().setHasText("John.Smith")).locator("//input[@name=\"chkSelectRow[]\"]").click();
		
		page.locator("button:has-text('Click To Open Window Alert')").click();
		Thread.sleep(2000);
		
		page.onDialog(dialog->{
			String text= dialog.message();
			System.out.print(text);
			dialog.dismiss();
		});
		page.click("button:has-text('Click To Open Window Alert')");
		List<String> lss= page.locator("div.elementor-widget-wrap:has(a[href='https://selectorshub.com/one-on-one-support-on-call/'])").allInnerTexts();
		lss.forEach(e->System.out.println(e));
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
		/*
		 * Page page2= context.newPage();
		 * page2.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		 * page2.click("button:has-text('Click for JS Alert')"); Thread.sleep(3000);
		 */
				}
	
	public void javascript() throws Throwable
	{
		
		playwright= Playwright.create();
		
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1536,703));
		Page page= context.newPage();
	//	page.navigate("https://google.com");
		
		page.onDialog(dialog->{
			String text=dialog.message();
			System.out.println(text);
			dialog.accept("asd");
			
		});
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts",new Page.NavigateOptions().setTimeout(30000));
		page.waitForLoadState();
	
		page.click("button:has-text('Click for JS Confirm')");
		Thread.sleep(3000);
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
	}
	
	public static void main(String[]  args) throws Throwable
	{
		/*
		 * App app= new App(); app.navigate(); // app.javascript();
		 */
		Playwrightfactory pl= Playwrightfactory.getinstance();
		Page page= pl.init();
		page.navigate("https://google.com");
	}
}
