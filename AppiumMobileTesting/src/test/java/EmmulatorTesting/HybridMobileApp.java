package EmmulatorTesting;

import java.net.URL;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HybridMobileApp {
   public static AndroidDriver driver;
	public static void main(String[] args) throws Exception {
		DesiredCapabilities capability =new DesiredCapabilities();
		capability.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability("AUTOMATION_NAME", "UiAutomator2");
		capability.setCapability("DEVICE_NAME", "AppiumTest");
		capability.setCapability("APP_PACKAGE", "com.google.android.apps.messaging");
		capability.setCapability("APP_ACTIVITY", "com.google.android.apps.messaging.ui.ConversationListActivity");
		//capability.setCapability("BROWSER_NAME", "chrome");
		capability.setCapability("CHROMEDRIVER_EXECUTABLE","C:\\Users\\rukes\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		capability.setCapability("NO_RESET", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.findElement(AppiumBy.accessibilityId("More options")).click();
		driver.findElement(By.xpath("//*[@text='Help & feedback']")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.accessibilityId("More options")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='Privacy policy']")).click();

		Set<String> allContextHandles = driver.getContextHandles();
		System.out.println(allContextHandles);
		driver.context("WEBVIEW_chrome");
		String chrome_browser_text=driver.findElement(By.xpath("//*[@class='q0cs9b']")).getText();
		System.out.println(chrome_browser_text);
	}
}
