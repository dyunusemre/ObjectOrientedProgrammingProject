package oopProject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AutoDownloadCSV {
	
	public void downloadFile(String id){
		
		System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
		
		try{			
			
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> preferences = new HashMap<String, Object>();
									
			preferences.put("plugins.plugins_disabled",new String[]{"Adobe Flash Player",
					"Chrome PDF Viewer"});
			
			preferences.put("download.default_directory", "C:\\Users\\Yunus Emre\\Downloads\\Publication");
						
			options.setExperimentalOption("prefs",preferences);
			
			options.addArguments("window-size=800,400");
			
			ChromeDriver chrome = new ChromeDriver(options);
			
			chrome.get("http://dl.acm.org/citation.cfm?id="+id);
			
			chrome.findElement(By.name("FullTextPDF")).click();
			
			Thread.sleep(5000);
			
			chrome.quit();
			
		}catch(Exception ex){
			
			
			
		}
		
	}
	
}
