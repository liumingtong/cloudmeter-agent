package cloud_meter_agent.cloud_meter_agent;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cloud_meter_agent.cloud_meter_agent.constants.Constants;
import cloud_meter_agent.cloud_meter_agent.model.NetWorkInfo;
import cloud_meter_agent.cloud_meter_agent.service.NetWorkService;

public class BaiduTest {
	private WebDriver driver;
	private ChromeDriverService service;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	Logger logger = Logger.getLogger(BaiduTest.class);
	static {
		PropertyConfigurator
				.configure("E:\\home\\workspace\\cloud-meter-agent\\src\\main\\resources\\log4j.properties");
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty(Constants.WEBDRIVERPATH_CHROM_KEY, Constants.WEBDRIVERPATH_CHROM_VALUE);
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(Constants.WEBDRIVERPATH_CHROM_VALUE))
				.usingAnyFreePort().build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		driver = new ChromeDriver(caps);
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

		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | |
		// ]]
		// driver.findElement(By.id("request-menu-context-save-all-as-har")).click();

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
		try {
			List<NetWorkInfo> netWorkInfos = new ArrayList<NetWorkInfo>();

			LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
			for (LogEntry entry : logEntries) {
				// logger.debug(new Date(entry.getTimestamp()) + " " +
				// entry.getLevel() + " " + entry.getMessage());
				NetWorkInfo netWorkInfo = NetWorkService.getInstance().dealNetWorkInfo(entry.getMessage());
				if(netWorkInfo != null) {
					netWorkInfos.add(netWorkInfo);
				}
			}

		} catch (Error error) {
			logger.debug("=======error:" + error);
		} catch (Exception exception) {
			logger.debug("=======exception:" + exception);
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
