package RealDeviceTesting;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class MobileWebApp {
public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
		Capabilities.setCapability("AUTOMATION_NAME","UiAutomator2");
		Capabilities.setCapability("UDID","*********");
		Capabilities.setCapability("BROWSER_NAME","chrome");
		Capabilities.setCapability("CHROMEDRIVER_EXECUTABLE","C:\\Users\\rukes\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");      
		Capabilities.setCapability("NO_RESET", "true");
		URL Url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(Url,Capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//*[@placeholder='Search Amazon']")).sendKeys("Machine Learning Books");
		driver.findElement(By.xpath("//*[@value='Go']")).click();
	}
}

