package oopProject;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


 
public class FileDownloader {
	
	private WebDriver driver;
	private String localDownloadPath = System.getProperty("java.io.tmpdir");
	
	public FileDownloader(WebDriver driverObject){
		this.driver = driverObject;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public String localDownloadPath(){
		
		return this.localDownloadPath;
		
	}
	
	public void localDownloadPath(String filePath){
		
		this.localDownloadPath = filePath;
		
	}
	
	
	public String downloadFile(WebElement element) throws NullPointerException, MalformedURLException, URISyntaxException{
		
		return downloader(element,"href");
		
	}
	
	private String downloader(WebElement element,String attribute) throws NullPointerException,URISyntaxException, MalformedURLException  {
		
		String fileToDownloadLocation = element.getAttribute(attribute);
		
		if(fileToDownloadLocation.trim().equals("")) throw new NullPointerException("DOESNT LINK");
		
		URL fileToDownload = new URL(fileToDownloadLocation);
		File downloadedFile = new File(this.localDownloadPath + fileToDownload.getFile().replaceFirst("/|\\\\", ""));
		if (downloadedFile.canWrite() == false) downloadedFile.setWritable(true);
	
		
		String downloadedFileAbsolutePath = downloadedFile.getAbsolutePath();
		
		return downloadedFileAbsolutePath;
		
	}
	
}

