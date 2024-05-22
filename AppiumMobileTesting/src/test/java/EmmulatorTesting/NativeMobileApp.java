package EmmulatorTesting;

import java.net.URL;
import java.util.List;
import java.util.prefs.Preferences;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

   public class NativeMobileApp {
	 public static WebDriver driver;
		public static void main(String[] args) throws Exception {
			        //desired capabilities to connect to a emulator
					DesiredCapabilities Capabilities = new DesiredCapabilities();
					Capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
					Capabilities.setCapability("AUTOMATION_NAME","UiAutomator2");
					Capabilities.setCapability("APP","C:\\appium sampleApk\\ApiDemos-debug.apk");
					Capabilities.setCapability("DEVICE_NAME","AppiumFirstTest");
			        
					driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), Capabilities);
			        WebElement pref_button = driver.findElement(AppiumBy.xpath("//*[@text='Preference']"));
			        pref_button.click();
			    
			        preference("4. Default values");
			        //1-->checkbox in emulator
			        WebElement checkbox = driver.findElement(By.id("android:id/checkbox"));
				    if(checkbox.getAttribute("checked").equalsIgnoreCase("true")) { 
				          checkbox.click();
				    }
				    
				    //2-->textbox in the emulator
				    Thread.sleep(2000);
				    WebElement TextBox = driver.findElement(By.xpath("//*[@text='Edit text preference']"));
				    TextBox.click();
				    WebElement edit_text = driver.findElement(By.id("android:id/edit"));
				    edit_text.clear();
				    Thread.sleep(3000);
				    edit_text.sendKeys("prefTextBox");
				    WebElement click_OK = driver.findElement(By.xpath("//*[@text='OK']"));
				    click_OK.click();
				    
				    TextBox = driver.findElement(By.xpath("//*[@text='Edit text preference']"));
				    TextBox.click();
				    edit_text = driver.findElement(By.id("android:id/edit"));
					System.out.println(edit_text.getAttribute("text"));
					click_OK = driver.findElement(By.xpath("//*[@text='OK']"));
				    click_OK.click();
				    Thread.sleep(2000);
				    driver.navigate().back();
					
				    //3-->Radiobuttons
				    Thread.sleep(1000);
				    preference("3. Preference dependencies");
			    	WebElement wifisettings =driver.findElement(By.xpath("//*[@text='WiFi settings']"));
				    WebElement wifi_on_off = driver.findElement(By.id("android:id/checkbox"));
				    wifi_on_off.click(); 
				    System.out.println("wifi_on_offstatus"+wifi_on_off.getAttribute("checked"));
				    System.out.println("wifisettingsstatus:"+wifisettings.getAttribute("enabled"));
				    wifi_on_off.click();
				    System.out.println("wifi_on_offstatus"+wifi_on_off.getAttribute("checked"));
				    System.out.println("wifisettingsstatus:"+wifisettings.getAttribute("enabled"));
			        driver.navigate().back();
			         
			        //switchButton
			        Thread.sleep(1000);
			        preference("9. Switch");
			        WebElement switchbutton = driver.findElement(By.xpath("//*[@text = 'This is a switch']//parent::*//parent::*//*[@resource-id='android:id/switch_widget']"));
			        switchbutton.click();
			        System.out.println("switchbutton--->"+switchbutton.getAttribute("text"));
			        	
			        WebElement switchbutton2 = driver.findElement(By.xpath("//*[@text = 'This is a switch with custom text']//parent::*//parent::*//*[@resource-id='android:id/switch_widget']"));
			        switchbutton2.click();
			        System.out.println("switchbutton--->"+switchbutton2.getAttribute("text"));
		           }
                /*************************************************************************/
				//method for Prefernce 
			        public static void preference(String chooseoption) {
			        List<WebElement> preference_options = driver.findElements(By.xpath("//android.widget.TextView"));
			        for(WebElement each_pref_option : preference_options ) {
		           	//System.out.println(each_pref_option.getText());
		           	if(each_pref_option.getText().contains(chooseoption)) {
		           		each_pref_option.click();
		           		break;
		           	}
		        }
		         /***********************************************************************/
	   }
  }
