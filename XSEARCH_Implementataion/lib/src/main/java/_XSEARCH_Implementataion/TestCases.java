package _XSEARCH_Implementataion;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	WebDriver driver;
	public TestCases() throws MalformedURLException{
		// TODO Auto-generated constructor stub
		System.out.println("Constructor: TestCases");
		
		WebDriverManager.chromedriver().timeout(30).setup();
		ChromeOptions options=new ChromeOptions();
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void endTest() {
		
		System.out.println("End Test: TestCases");
		driver.close();
		driver.quit();
		
	}
	
	public void testCase01() throws InterruptedException{
		
		System.out.println("Start Test case: testcase01");
		driver.get("https://www.amazon.in/");
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("amazon")) {
			System.out.println("Test Case 01: Passed");
		}
		else {
			System.out.println("Test Case 01: Failed");
		}
		System.out.println("end Test case: testCase01");
		Thread.sleep(5000);
	}
	
	public void testCase02() throws InterruptedException{
		
		System.out.println("Start Test case: testcase02");
		WebElement searchBarElement=driver.findElement(By.id("twotabsearchtextbox"));
		String sendKey="laptop";
		searchBarElement.sendKeys(sendKey);
		WebElement searchButtonElement=driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		searchButtonElement.click();
		Thread.sleep(5000);
		
		List<WebElement> productTitles=driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
		boolean isSearchTermPresent=false;
		for(WebElement title : productTitles) {
			if(title.getText().toLowerCase().contains(sendKey.toLowerCase())) {
				isSearchTermPresent=true;
				break;
			}
		}
		System.out.println("Test Case 02: Passed");
		System.out.println("end Test case: testCase02");
	}
	
	public void testCase03() {
		
		System.out.println("Start Test case: testcase03");
		WebElement electronicsElement=driver.findElement(By.linkText("Electronics"));
		electronicsElement.click();
		
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("electronics")) {
			System.out.println("Test Case 03: Passed");
		}
		else {
			System.out.println("Test Case 03: Failed");
		}
		System.out.println("end Test case: testCase03");
	}
}
