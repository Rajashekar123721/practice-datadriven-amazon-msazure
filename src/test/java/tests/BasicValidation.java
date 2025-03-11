package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pom.DemoTest;

public class BasicValidation extends BaseTest {
	private DemoTest demoTest;

	@Test(priority = 1)
	public void product_Search() {
		demoTest = new DemoTest(driver);
		demoTest.searchProduct("iPhone");
		System.out.println("product search completed!!...");
	}

	@Test(priority = 2)
	public void get_Count() {
		System.out.println("Iphone list is displayed");
		int iphoneCount = demoTest.getProductCount();
		System.out.println("Total iPhones listed on the page: " + iphoneCount);
		Assert.assertTrue(iphoneCount > 0, "No iPhones found in search results.");
	}

	@Test(priority = 3)
	public void first_product_click() {

		demoTest.clickFirstProduct();

		System.out.println("First Product Got Clicked");

	}

	@Test(priority = 4)
	public void product_price() {
		String parentWindow = driver.getWindowHandle(); // Store the parent window

		// Wait for all windows and switch to the new one
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle); // Switch to new window
				break;
			}
		}

		String price = demoTest.getProductPrice();
		System.out.println("Product Price: ₹" + price);
		Assert.assertNotNull(price, "Price is not displayed");

		// Close the new tab and switch back to the main window
		driver.close();
		driver.switchTo().window(parentWindow);
	}
}