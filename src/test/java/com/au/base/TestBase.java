package com.au.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
					+ "\\DataDriven\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			or.load(fis);

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.vhrome.driver", System.getProperty("user.dir")+"\\src\\test\\executables\\chromedriver.exe");

			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.vhrome.driver", "chromedriver.exe");

			}

		}

	}

	@AfterSuite
	public void tearDown() {

	}
}
