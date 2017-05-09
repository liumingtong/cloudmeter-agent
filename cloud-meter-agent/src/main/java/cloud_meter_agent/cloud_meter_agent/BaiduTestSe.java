package cloud_meter_agent.cloud_meter_agent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import cloud_meter_agent.cloud_meter_agent.constants.Constants;

public class BaiduTestSe {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		System.setProperty(Constants.WEBDRIVERPATH_CHROM_KEY, Constants.WEBDRIVERPATH_CHROM_VALUE);
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.baidu.com/");
		selenium.start();
	}

	@Test
	public void testBaiduTestSe() throws Exception {
		selenium.open("/");
		selenium.click("id=kw");
		selenium.type("id=kw", "听云");
		selenium.click("id=su");
		selenium.click("id=su");
		selenium.selectFrame("");
		selenium.click("id=request-menu-context-save-all-as-har");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
