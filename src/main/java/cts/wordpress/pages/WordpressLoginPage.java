package cts.wordpress.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WordpressLoginPage {

	WebDriver deriver;
	By username=By.id("user_login");
	By password=By.xpath("//input[@id='user_pass']");
	By loginButton=By.xpath("//input[@id='wp-submit']");
	By checkbox=By.id("rememberme");

	public WordpressLoginPage(WebDriver deriver) {
		this.deriver=deriver;
	}

	public void typeUserName() {

		deriver.findElement(username).sendKeys("admin");
	}

	public void typePassword() {

		deriver.findElement(password).sendKeys("demo123");
	}
	public void clickOnLoginButton() {

		deriver.findElement(loginButton).click();
	}
}