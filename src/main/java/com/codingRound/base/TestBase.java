package com.codingRound.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codingRound.util.MSExcelAutomation;
import com.sun.jna.Platform;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static MSExcelAutomation datatable = null;
	
	//Setting up the configuration
	public TestBase() {
		try {
			prop = new Properties();
			String path = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\codingRound\\testdata\\Controller.xlsx";
			datatable = new MSExcelAutomation(path);
			FileInputStream fp = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\codingRound\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Loading the configuration
	public void initialization() {

		String browserName = prop.getProperty("BrowserName");

		if (Platform.isWindows()) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
			}

		} else if (Platform.isMac()) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver");
				driver = new FirefoxDriver();
			}
		} else if (Platform.isLinux()) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver_linux");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver_linux");
				driver = new FirefoxDriver();
			}

		}
		driver.get(prop.getProperty("testSiteURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
}
