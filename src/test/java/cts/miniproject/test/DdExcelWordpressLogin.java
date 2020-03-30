package cts.miniproject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cts.miniproject.utility.ExcelDataConfigg;
import io.github.bonigarcia.wdm.WebDriverManager;



public class DdExcelWordpressLogin {
	WebDriver driver;
	@Test(dataProvider="wordpress")
	public void loginToWordpress(String username,String password) throws Exception {

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP PC\\eclipse-workspace\\WordPress\\src\\test\\resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 

		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();


		Assert.assertEquals("http://demosite.center/wordpress/wp-admin/", driver.getCurrentUrl());

		System.out.println(driver.getCurrentUrl());
		System.out.println("User is able to login sucessfully");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name="wordpress")
	public Object[][] passData() {

		ExcelDataConfigg configExcel=new ExcelDataConfigg("C:\\Users\\HP PC\\eclipse-workspace\\WordPress\\Excel\\Testdata.xlsx");
		int noofrows=configExcel.getRowCount(0);
		Object[][] data=new Object[noofrows][3];

		for(int i=0;i<noofrows; i++) {
			data[i][0]=configExcel.getData(0, i, 0);
			data[i][1]=configExcel.getData(0, i, 1);
		}

		return data;
	}

}