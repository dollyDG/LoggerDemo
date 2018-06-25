package com.logger.LoggerDemo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class log4jDemo {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(log4jDemo.class);

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		log.debug("Launcing Chrome Driver");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("Window Maximised");
	}

	@Test
	public void test() {
		log.debug("Hitting Google.com");
		driver.get("https://www.google.com");
		log.info("Landed on Google Home Page");
		log.debug("Checking whether we have launched on correct page or not");
		// Assert.assertEquals("Google", driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("Google")) {
			log.info("Google is launched");
		} else {
			log.error("You are navigated to wrong page");
		}
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		log.debug("Closing browser instance");
		Thread.sleep(2000);
		driver.close();
	}
}
