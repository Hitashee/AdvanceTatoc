package advance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class GetDriver {

	static WebDriver getDriver()
	{
		FirefoxProfile profile = new FirefoxProfile();

	    String path = "/home/hitasheesil/Downloads";
	    profile.setPreference("browser.download.folderList", 2);
	    profile.setPreference("browser.download.dir", path);
	    profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/Gzip, application/csv, application/ris, text/csv,text/dat, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, applicaion/Gzip-archive, application/download, application/octet-stream");
	    profile.setPreference("browser.download.manager.showWhenStarting", false);
	    profile.setPreference("browser.download.manager.focusWhenStarting", false);  
	    profile.setPreference("browser.download.useDownloadDir", true);
	    profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	    profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	    profile.setPreference("browser.download.manager.closeWhenDone", true);
	    profile.setPreference("browser.download.manager.showAlertOnComplete", false);
	    profile.setPreference("browser.download.manager.useWindow", false);
	    profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
	    profile.setPreference("pdfjs.disabled", true);
	    WebDriver driver= new FirefoxDriver(profile);
	    
	    return driver;
	}
}
