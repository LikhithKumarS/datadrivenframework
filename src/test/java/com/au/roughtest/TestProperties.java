package com.au.roughtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		Properties or = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		System.out.println(System.getProperty("user.dir"));
		config.load(fis);
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		or.load(fis);

		

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aurigininc\\git\\datadrivenframework\\src\\test\\resources\\executables\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		
		driver = new ChromeDriver();
		driver.get("www.google.com");

	}

}
