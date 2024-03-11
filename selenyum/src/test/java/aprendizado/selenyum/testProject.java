package aprendizado.selenyum;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class testProject {
	
	@Test
	public void setup()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		WebDriver driver =  new ChromeDriver(chromeOptions);
		driver.get("http://m.dominos.co.in");
		
		System.out.println("test case executed-----------------assasas-asa@@@@@@@&@#*(&@(&@(!&@(!&@(!&@(!&@(!(@(");
	}

}
