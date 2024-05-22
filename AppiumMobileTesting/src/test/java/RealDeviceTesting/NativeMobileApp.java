 package RealDeviceTesting;

import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class NativeMobileApp {
		 public static WebDriver driver;
		 public static void main(String[] args) throws Exception {
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			Capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability("AUTOMATION_NAME","UiAutomator2");
			Capabilities.setCapability("UDID","**********");
			Capabilities.setCapability("APP_PACKAGE","com.android.calculator2");
			Capabilities.setCapability("APP_ACTIVITY","com.android.calculator2.Calculator");
			Capabilities.setCapability("NO_RESET", "true");
			URL Url = new URL("http://127.0.0.1:4723/wd/hub");
	        driver = new AndroidDriver(Url,Capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(AppiumBy.xpath("//*[@text='9']")).click();
			driver.findElement(AppiumBy.accessibilityId("plus")).click();
			driver.findElement(AppiumBy.xpath("//*[@text='6']")).click();
			driver.findElement(AppiumBy.accessibilityId("equals")).click();
			driver.navigate().back();	
		}
	}