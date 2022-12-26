package org.win;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleWindowNewTab {
	
	WebDriver driver = null;
	@Test(priority=0)
	private void google() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		

	}
	@Test(priority=1)
	private void facebook() {
		driver.get("https://www.facebook.com");
		String parentID = driver.getWindowHandle();
		Set<String> allWinIDs = driver.getWindowHandles();
		List<String> li =new ArrayList<>(allWinIDs);
				driver.switchTo().window(li.get(0));
		driver.findElement(By.name("q")).sendKeys("Automation"+Keys.ENTER);
		driver.switchTo().window(li.get(1));
		

	}
	

}
