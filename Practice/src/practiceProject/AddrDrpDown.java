package practiceProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddrDrpDown {

	public static void main(String[] args) {

		WebDriver driver;

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.whitecircleschool.com/");

		driver.findElement(By.id("username-8")).sendKeys("Indu");
		driver.findElement(By.id("user_password-8")).sendKeys("Drushru1");
		driver.findElement(By.id("um-submit-btn")).click();

		driver.findElement(By.id("work")).click();
		driver.findElement(By.xpath("//a[contains(@href,'a2')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'branches')]")).click();

		WebElement region = driver.findElement(By.id("select1"));

		Select select1 = new Select(region);
		List<WebElement> regions = select1.getOptions();
		

		WebElement country = driver.findElement(By.name("select2"));

		// List<WebElement> countries = select2.getOptions();
		
		 

		for (WebElement y: regions) {

			y.click();
			
			if(!(y.getText().equals("Select"))){
					
			System.out.println("-------------------");
			System.out.println(y.getText());
			System.out.println("-------------------");
			
			}

			Select select2 = new Select(country);
			List<WebElement> countries = select2.getOptions();

			for (WebElement x : countries) {

				x.click();
				String addressText = driver.findElement(By.id("address")).getText();
				boolean addrDispalyedStatus1 = addressText.isEmpty();
				//boolean addrDispalyedStatus = driver.findElement(By.id("address")).isDisplayed();
				
				

				if ((!(addrDispalyedStatus1)) && (!(x.getText().equals("Select")))) {
					System.out.println(x.getText());
					System.out.println("Address present");
					//System.out.println(addressText);
					System.out.println("");
					
				} else {
					if (x.getText().equals("Select")) {
						continue;
					}
					System.out.println(x.getText());
					System.out.println("Address not present");
				}

			}

		}

	}
}
