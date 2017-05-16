package cloud_meter_agent.cloud_meter_agent;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import cloud_meter_agent.cloud_meter_agent.constants.Constants;

public class BaiduTest {
	private WebDriver driver;
	private ChromeDriverService service;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	Logger logger = Logger.getLogger(BaiduTest.class);
	static {
		PropertyConfigurator.configure(
				"E:\\home\\git\\cloudmeter\\cloudmeter-agent\\cloud-meter-agent\\src\\main\\resources\\log4j.properties");
	}

	@Before
	public void setUp() throws Exception {
		// System.setProperty(Constants.WEBDRIVERPATH_CHROM_KEY,
		// Constants.WEBDRIVERPATH_CHROM_VALUE);
		System.setProperty(Constants.WEBDRIVERPATH_PHANTOMJS_KEY, Constants.WEBDRIVERPATH_PHANTOMJS_VALUE);
		PhantomJSDriverService service = new PhantomJSDriverService.Builder()
				.usingPhantomJSExecutable(new File(Constants.WEBDRIVERPATH_PHANTOMJS_VALUE)).withLogFile(null).build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				Constants.WEBDRIVERPATH_PHANTOMJS_VALUE);
		driver = new PhantomJSDriver(caps);
		/*
		 * System.setProperty(Constants.WEBDRIVERPATH_FIREFOX_KEY,
		 * Constants.WEBDRIVERPATH_FIREFOX_VALUE); driver = new FirefoxDriver();
		 */
		baseUrl = "https://www.baidu.com/";
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void testBaidu() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).sendKeys("听云");
		driver.findElement(By.id("su")).click();

		analyzeLog();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		service.stop();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get("har");
		for (LogEntry entry : logEntries) {
			logger.debug(entry.getMessage());
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
