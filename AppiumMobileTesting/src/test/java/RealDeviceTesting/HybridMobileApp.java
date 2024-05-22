package RealDeviceTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HybridMobileApp {
     public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, Exception {
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
		Capabilities.setCapability("AUTOMATION_NAME","UiAutomator2");
		Capabilities.setCapability("UDID","TA0980J4B8");
		Capabilities.setCapability("APP_PACKAGE", "com.google.android.apps.googlevoice");
		Capabilities.setCapability("APP_ACTIVITY", "com.google.android.apps.voice.home.HomeActivity");
		//Capabilities.setCapability("BROWSER_NAME", "chrome");
		Capabilities.setCapability("CHROMEDRIVER_EXECUTABLE","C:\\Users\\rukes\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		Capabilities.setCapability("NO_RESET", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		driver.findElement(AppiumBy.xpath("//*[@content-desc='Navigation menu']")).click();
        driver.findElement(AppiumBy.xpath("//*[@text='Settings']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@content-desc='More options']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//*[@text='About']")).click();
	}
}