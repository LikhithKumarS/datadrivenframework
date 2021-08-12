package com.au.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static Properties config;
	public static Properties or;
	public static FileInputStream fis;

	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			or.load(fis);

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\executables\\chromedriver.exe");

			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

			}
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

		}

	}

	@AfterSuite
	public void tearDown() {
if(driver!=null) {
	driver.quit();
}
	}
}
