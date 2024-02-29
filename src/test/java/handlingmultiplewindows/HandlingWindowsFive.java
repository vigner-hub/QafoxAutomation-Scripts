package handlingmultiplewindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindowsFive {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		String omayoWindowId = driver.getWindowHandle();
		
		WebElement popupWindowLink = driver.findElement(By.linkText("Open a popup window"));
		popupWindowLink.click();
		
		WebElement bloggerWindowLink = driver.findElement(By.linkText("Blogger"));
		bloggerWindowLink.click();
		
		switchToWindow("New Window",driver);
		
		WebElement popupWindowHeading = driver.findElement(By.xpath("//h3"));
		String popupWindowHeadingText = popupWindowHeading.getText();
		System.out.println(popupWindowHeadingText);

		switchToWindow("Blogger.com - Create a unique and beautiful blog easily.",driver);
		
		WebElement siginOption = driver.findElement(By.xpath("//span[text()='Sign in']"));
		siginOption.click();
		
		driver.switchTo().window(omayoWindowId);
		
		WebElement textAreaField = driver.findElement(By.id("ta1"));
		textAreaField.sendKeys("Arun Motoori");

	}
	
	
	public static void switchToWindow(String windowTitle,ChromeDriver driver) {
		
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String windowId : windowIds) {
			
			driver.switchTo().window(windowId);
			
			String actualTitle = driver.getTitle();
			
			if(actualTitle.equals(windowTitle)) {
				
				break;
				
			}
			
		}
		
	}

}
