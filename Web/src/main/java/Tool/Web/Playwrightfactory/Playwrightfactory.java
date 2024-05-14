package Tool.Web.Playwrightfactory;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;

public class Playwrightfactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	
	public static ThreadLocal<Playwright> tlplaywright= new ThreadLocal();
	public static ThreadLocal<Browser> tlbrowser= new ThreadLocal();
	public static ThreadLocal<BrowserContext> tlbrowsercontext= new ThreadLocal();
	public static ThreadLocal<Page> tlpage= new ThreadLocal();
	public static Playwrightfactory playwrightfactory=null;
	
	private Playwrightfactory()
	{
	}
	
	public static synchronized Playwrightfactory getinstance()
	{
		
		if(playwrightfactory==null)
		{
			playwrightfactory= new Playwrightfactory();
		}
		return playwrightfactory;
	}
	
	public static Playwright getplaywright()
	{
		return tlplaywright.get(); 
	}
	
	public static Browser getbrowser()
	{
		return tlbrowser.get();
	}
	public static BrowserContext getbrowsercontext()
	{
		return tlbrowsercontext.get();
	}
	public static Page getpage()
	{
		return tlpage.get();
	}
	
	public Page init()
	{
		
		tlplaywright.set(Playwright.create());
		
		
		tlbrowser.set(getplaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
		tlbrowsercontext.set(getbrowser().newContext());
		tlpage.set(getbrowsercontext().newPage());
			
		return getpage();		
	}
	

}
