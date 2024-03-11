package aprendizado.selenyum;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class imageComparisonShutterBug {

	public static void main(String args[]) throws IOException
	{
		ChromeOptions options  = new ChromeOptions();
		Map<String, String> mobileEmulation = new HashMap();
		mobileEmulation.put("deviceName", "Galaxy S5");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
	    options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://m.dominos.co.in");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("var script = document.createElement('script'); script.src = 'https://code.jquery.com/jquery-3.6.4.min.js'; document.head.appendChild(script);");

		//to get expected image 
		BufferedImage expectedImage=ImageIO.read(new File("/Users/ayush.kulshrestha/Downloads/appLogo.png"));
		
		//Shutterbug.shootPage(driver).withName(null)
		
}

}