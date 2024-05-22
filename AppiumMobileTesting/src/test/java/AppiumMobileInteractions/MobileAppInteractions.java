package AppiumMobileInteractions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class MobileAppInteractions {
  public static AndroidDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		//desired capabilities to connect to a emulator
				DesiredCapabilities Capabilities = new DesiredCapabilities();
				Capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
				Capabilities.setCapability("AUTOMATION_NAME","UiAutomator2");
				Capabilities.setCapability("APP","C:\\appium sampleApk\\ApiDemos-debug.apk");
				Capabilities.setCapability("DEVICE_NAME","AppiumFirstTest");
					
		        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		        WebElement views_Btn = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));
		        views_Btn.click();
				      
			      clickontextView("Expandable");
			      clickontextView("Custom Adapter");

			      WebElement PeopleNames=driver.findElement(By.xpath("//*[@text='People Names']"));
			      TouchAction t =new TouchAction(driver);
			      t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(PeopleNames))
			      .withDuration(Duration.ofSeconds(2))).release().perform();
		          navigateBack(3);
			     
		          clickontextView("Date Widgets");
			      clickontextView("Inline");

			      handleClockSwipes(t, 6);
			      handleClockSwipes(t, 55);

			      navigateBack(2);
			      clickontextView("Drag and Drop");

			      WebElement sourceDot=driver.findElement(By.xpath("//*[contains(@resource-id,'drag_dot_1')]"));
			      WebElement destinationDot=driver.findElement(By.xpath("//*[contains(@resource-id,'drag_dot_2')]"));

			      t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(sourceDot)))
			      .moveTo(ElementOption.element(destinationDot)).release().perform();

			      }

			      @SuppressWarnings("deprecation")
				  public static void handleClockSwipes(TouchAction t,int clockDestination) {
			      WebElement currentlySelected=driver.findElement(By.xpath("//*[@resource-id='android:id/radial_picker']//*[@selected='true']"));
			      System.out.println(currentlySelected.getAttribute("content-desc"));

			      WebElement clockHrsDestination=driver.findElement(By.xpath("//*[@resource-id='android:id/radial_picker']//*[@content-desc='"+clockDestination+"']"));

			      t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(currentlySelected))
			      .withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(clockHrsDestination)).release().perform();

			      }
			      /*********************************************************/
			      public static void clickontextView(String option_to_click) {

				      List<WebElement> pref_page_Options = driver.findElements(By.xpath("//android.widget.TextView"));
				      for(WebElement each_pref_page_Options: pref_page_Options) {
				      if(each_pref_page_Options.getText().contains(option_to_click)) {
				      each_pref_page_Options.click();
				      break;
				      }
				     }
				 }
				 /**********************************************************/
		   
				  public static void navigateBack(int numOfNavigations) {
				  for(int i=1;i<=numOfNavigations;i++) {
				  driver.navigate().back();
				  
				  /************************************************************/
			      }
			    }
           }
	
	