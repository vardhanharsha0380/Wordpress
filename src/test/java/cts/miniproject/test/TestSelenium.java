package cts.miniproject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cts.miniproject.utility.ConfigReader;

public class TestSelenium {
ConfigReader config;
@BeforeTest
public void setup() {

config=new ConfigReader();

System.setProperty("webdriver.chrome.driver", config.getchromepath());

System.out.println("Set up is Ready");

}

@Test
public void testchrome() {
System.out.println("Navigate to URL");
WebDriver driver=new ChromeDriver();
driver.get(config.getApplicationURL());


}
}