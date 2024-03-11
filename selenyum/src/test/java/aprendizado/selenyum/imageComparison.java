package aprendizado.selenyum;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class imageComparison {
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		ChromeOptions options  = new ChromeOptions();
		Map<String, String> mobileEmulation = new HashMap();
		mobileEmulation.put("deviceName", "Galaxy S5");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
	    options.addArguments("--disable-notifications");
	    options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://m.dominos.co.in/");
		driver.manage().window().maximize();
		//driver.get("https://pizzaonline.dominos.co.in/menu");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("var script = document.createElement('script'); script.src = 'https://code.jquery.com/jquery-3.6.4.min.js'; document.head.appendChild(script);");
		//to get expected image 
		BufferedImage expectedImage=ImageIO.read(new File("/Users/ayush.kulshrestha/Downloads/appLogo.png"));
		//driver.findElement(By.xpath("//span[text()='Skip']")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id=\"pageTop\"]/div[2]/div/span/i")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[text()='Nutritional Information']")).click();
		
		//WebElement imageLogo=driver.findElement(By.xpath("//img[@alt='Dominos Logo']"));
		Thread.sleep(10000);
		WebElement logoElement=driver.findElement(By.cssSelector("img[alt='Dominos Logo']"));
		//WebElement logoElement = driver.findElement(By.cssSelector("your-logo-selector"));
		//if (logoElement.isDisplayed() && logoElement.getSize().getWidth() > 0 && logoElement.getSize().getHeight() > 0) {
		    // Take a screenshot
		//}
		//Screenshot fullPageScreenshot = new AShot()
		  //      .shootingStrategy(ShootingStrategies.simple())
		    //    .coordsProvider(new WebDriverCoordsProvider())
		      //  .takeScreenshot(driver);	
        File fullPageScreenshotFile = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage fullPageImage = null;
        
            fullPageImage = ImageIO.read(fullPageScreenshotFile);
            BufferedImage logoImage = fullPageImage.getSubimage(
                    logoElement.getLocation().getX(),
                    logoElement.getLocation().getY(),
                    logoElement.getSize().getWidth(),
                    logoElement.getSize().getHeight());
                    
            

            // Save the logo screenshot to a file
           // saveScreenshot(logoImage, "path/to/logo-screenshot.png");
		//BufferedImage logoScreenshot = fullPageScreenshot.getImage();
        //int logoX = logoElement.getLocation().getX();
        //int logoY = logoElement.getLocation().getY();
        //int logoWidth = logoElement.getSize().getWidth();
        //int logoHeight = logoElement.getSize().getHeight();
        
       // BufferedImage croppedLogoImage = logoScreenshot.getSubimage(logoX, logoY, logoWidth, logoHeight);
        
        ImageIO.write(logoImage, "png", new File("/Users/ayush.kulshrestha/Downloads/test5.png"));

        driver.quit();
        }}
	//	Screenshot imageLogoSS =new AShot().takeScreenshot(driver,imageLogo);
		
		//File imageLogoSS=imageLogo.getScreenshotAs(OutputType.FILE);
		//ImageIO.write(imageLogoSS.getImage(), "png", new File("/Users/ayush.kulshrestha/Downloads/test2.png"));
		
		//BufferedImage actualImage=imageLogoSS.getImage();
		
//		ImageDiffer imgDiff = new ImageDiffer();
//		ImageDiff diff=imgDiff.makeDiff(expectedImage, actualImage);
//		
//		if(diff.hasDiff()==true)
//		{
//			System.out.println("images are not same");
//		}
//		else {
//			System.out.println("images are same");
//		}
//		
//		driver.quit();
//	}


