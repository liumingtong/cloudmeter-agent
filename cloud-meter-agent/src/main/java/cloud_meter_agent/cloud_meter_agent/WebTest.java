package cloud_meter_agent.cloud_meter_agent;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartChrome();
	}

	public static void StartChrome() {
		System.setProperty(Constants.WEBDRIVERPATH_CHROM_KEY, Constants.WEBDRIVERPATH_CHROM_VALUE);
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(Constants.WEBDRIVERPATH_CHROM_VALUE)).usingAnyFreePort()
				.build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		
		 driver.findElement(By.id("kw")).click();
		    driver.findElement(By.id("kw")).clear();
		    driver.findElement(By.id("kw")).sendKeys("听云");
		    driver.findElement(By.id("su")).click();
		    driver.findElement(By.id("su")).click();
		    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame |  | ]]
		    driver.findElement(By.id("request-menu-context-save-all-as-har")).click();
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getNetworkConnection());
		
		driver.quit();
		// 关闭 ChromeDriver 接口
		service.stop();
	}

}
