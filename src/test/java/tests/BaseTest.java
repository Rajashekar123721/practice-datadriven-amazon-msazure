package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import pom.DemoTest;
import utils.Common;

import java.time.Duration;

public class BaseTest {
    
	public WebDriver driver;
    private Common common;
    protected DemoTest demoTest;

    @Parameters({"browser", "amazonUrl"})
    @BeforeTest
    public void setup(String browser, String url) {
        common = new Common();
        common.setupBrowser(browser, url);
        driver = common.getBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        demoTest = new DemoTest(driver);
    }

    @AfterTest
    public void teardown() {
        common.quitBrowser();
    }
}
