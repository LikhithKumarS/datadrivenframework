package com.au.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.au.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void login() {
		log.debug("Inside login test");

		driver.findElement(By.cssSelector("login_btn")).click();
		
	}
}
