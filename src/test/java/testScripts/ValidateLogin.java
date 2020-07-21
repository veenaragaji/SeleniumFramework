package testScripts;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import customListeners.TestListeners;
import pageObjects.HomePage;
import testBase.BaseClass;

//@Listeners(TestListeners.class)
public class ValidateLogin extends BaseClass {
	WebDriver driver;
	ExtentTest test;
	/*@BeforeClass
	public void b4class2() throws IOException {
		System.out.println("Before Class - Login page");
	}
	@BeforeTest
	public void b4test2() throws IOException {
		System.out.println("Before Test - Login page");
	}*/
	@BeforeMethod
	public void initialize() throws IOException {
		driver = getDriverConfig();
		driver.get(prop.getProperty("Url"));
		System.out.println("Test2 Before Method -Login");
	}
	
	@Test
	public void login() throws IOException, InterruptedException {
		test=TestListeners.test;
		HomePage hp = new HomePage(driver);
		// driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		// Thread.sleep(4000);
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "/html/body/app-root/div/header/div[1]/div/div/div[2]/div[2]")));
		 * ///html/body/app-root/div/header/div[1]/div/div/div[2]/div[2]
		 */
		WebElement loginB = hp.getLogin();
		test.log(Status.PASS, "Step1-Login button identified-"+test.addScreenCaptureFromPath(getScreenShot("login", driver)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginB);
		test.log(Status.PASS, "Step2-Login success-"+test.addScreenCaptureFromPath(getScreenShot("login", driver)));
		System.out.println("Test2 method is successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Test2 After Method Login exited");
		
	}
	
	/*@AfterTest
	public void aftertest2() throws IOException {
		
		System.out.println("After Test - Login page");
	}
	@AfterClass
	public void afterclass2() throws IOException {
		System.out.println("After Class - Login page");
	}*/
}
