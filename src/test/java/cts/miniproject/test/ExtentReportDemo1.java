package cts.miniproject.test;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cts.miniproject.utility.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo1 {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	@BeforeMethod
	public void setupReport() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/Extentreport.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		logger = extent.createTest("loginTest", "Description");
	}

	@AfterMethod
	public void tearDownReport(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			Screenshot screenshot=new Screenshot(); 
			String temp= screenshot.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		}
		extent.flush();
		driver.quit();
	}
	@Test
	public void loginTest() {
		//System.setProperty("webdriver.chrome.driver", "F:\\sumi\\sample-selenium\\src\\test\\resources\\binaries\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 

		driver.get("https://www.google.com/");

		Assert.assertTrue(driver.getTitle().contains("sumithra"));

	}


}