package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.beust.jcommander.Parameter;

import pom.DemoTest;

public class BasicValidation extends BaseTest {
	//private DemoTest demoTest;

	@Test(priority = 1)
	public void urlValidation() {
		demoTest = new DemoTest(driver);
		String expectedResult = "https://www.amazon.in/";
		String actualResult = driver.getCurrentUrl();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the URL,");		
	}
	
	@Test(priority = 2)
	public void titleValidation() {
		String expectedResult = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualResult = driver.getTitle();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");		
	}
	
	@Parameters({"productName"})
	@Test(priority = 3)
	public void product_Search(String product) {
		
		demoTest.searchProduct(product);
		System.out.println("product search completed!!...");
	}
	

	@Test(priority = 4)
	public void get_Count() {
		System.out.println("Iphone list is displayed");
		String expectedResult = "1-16 of over 50,000 results for \"iphone 16\"";
		String actualResult = demoTest.resultDisplay1() +" "+ demoTest.resultDisplay2();
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	
		
		int iphoneCount = demoTest.getProductCount();
		System.out.println("Total iPhones listed on the page: " + iphoneCount);
		
		
	}

	@Test(priority = 5)
	public void first_product_click() {

		demoTest.clickFirstProduct();

		System.out.println("First Product Got Clicked");

	}

	
	
	@Test(priority = 6)
	public void product_price() {
		String price = demoTest.getProductPrice();
		System.out.println("Product Price: ₹" + price);
		Assert.assertNotNull(price, "Price is not displayed");
		String expectedResult = "₹73,400";
		String actualResult = demoTest.getCurrencySymbol()+demoTest.getProductPrice();
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	

		
		
		
		// Close the new tab and switch back to the main window
		//driver.close();
		// driver.switchTo().window(parentWindow);
		// driver.switchTo().window(driver.getWindowHandles().iterator().next());
		 }
	
	@Test(priority = 7)
	public void verify_brand(){
		
		String expectedResult = "Apple";
		String actualResult = demoTest.getBrand();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	
		
	}
	
	@Test(priority = 8)
	public void verify_OS(){
		
		String expectedResult = "iOS 17";
		String actualResult = demoTest.getOperatingSystem();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	
		
	}
	
	@Test(priority = 9)
	public void verify_ram_memory(){
		
		String expectedResult = "128 GB";
		String actualResult = demoTest.getRAM_Memory();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	
		
	}
	
	@Test(priority = 10)
	public void verify_memory_capacity(){
		
		String expectedResult = "128 GB";
		String actualResult = demoTest.getMemory_Capacity();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	
		
	}
	
	
	@Test(priority = 11)
	public void verify_screen_size(){
		
		String expectedResult = "6.1 Inches";
		String actualResult = demoTest.getScreens_Size();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");	
		
	}
	
	
	
	
}