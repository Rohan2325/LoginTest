package TestngPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest {
	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F");
	    }

	    @Test
	    public void testSuccessfulLogin() {
	        WebElement emailField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log In']"));

	        emailField.sendKeys("tylertyler12@gmail.com");
	        passwordField.sendKeys("Tylertyler12");
	        loginButton.click();
	        
           String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";
	       Assert.assertEquals(driver.getCurrentUrl(),expectedUrl, "user was not redirected to landing page" );
	       driver.findElement(By.xpath("//span[@class='d-none d-sm-inline mx-1']")).click();
	    	driver.findElement(By.xpath("//i[@class='bi bi-box-arrow-right']//parent::span")).click();
	    }
	    
	    @Test
	    public void testUnsuccessfulLogin() {

	        WebElement emailField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log In']"));

	        emailField.sendKeys("invalidid@.com");
	        passwordField.sendKeys("invalidPassword");
	        loginButton.click();
	     
	       String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";
	       String actualUrl = driver.getCurrentUrl();
	       Assert.assertEquals(actualUrl, expectedUrl);
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}

