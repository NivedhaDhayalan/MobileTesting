package EmmulatorTesting;

import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class MobileWebApp {
	 public static AndroidDriver driver;
		public static void main(String[] args) throws Exception {
			//desired capabilities to connect to a emulator
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			Capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability("AUTOMATION_NAME","UiAutomator2");
			Capabilities.setCapability("BROWSER_NAME","chrome");
			Capabilities.setCapability("DEVICE_NAME","AppiumFirstTest");
			Capabilities.setCapability("CHROMEDRIVER_EXECUTABLE","C:\\Users\\rukes\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");       	
			URL Url = new URL("http://127.0.0.1:4723/wd/hub");
	        driver = new AndroidDriver(Url,Capabilities);
		//	Thread.sleep(2000);
			driver.get("https://www.amazon.com/");
			driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Machine Learning Books");
			driver.findElement(By.xpath("//*[@value='Go']")).click();
			List<WebElement> products = driver.findElements(By.xpath("//*[contains(@class,'result-item')]//h2//span"));
			for(WebElement product : products) {
				System.out.println(product.getText());
			}
	  }
}