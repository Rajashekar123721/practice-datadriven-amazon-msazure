package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class DemoTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement productName;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "//span[contains(text(),'results')]")
	private WebElement totalResultsText;

	@FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	private WebElement totalProductText;

	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	private List<WebElement> productList;

	@FindBy(xpath = "//span[@class='a-price-whole']")
	private List<WebElement> productPrices;

	@FindBy(xpath = "//span[@class='a-price-symbol']")
	private List<WebElement> currencySymbol;

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement productTitle;

	@FindBy(xpath = "//span[@class='a-size-base po-break-word']")
	private List<WebElement> productDetails;

	public DemoTest(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	public void searchProduct(String product) {
		productName.sendKeys(product);
		searchButton.click();
	}

	public String resultDisplay1() {
		return totalResultsText.getText();
	}

	public String resultDisplay2() {
		return totalProductText.getText();
	}

	public int getProductCount() {

		wait.until(ExpectedConditions.visibilityOfAllElements(productList)); // Ensure products are visible
		return productList.size();
	}

	public void clickFirstProduct() {
		String parentWindow = driver.getWindowHandle();
		List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")));
		if (!productList.isEmpty()) {
			productList.get(0).click();
		}

		// Switch to new window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	public String getProductPrice() {

		if (!productPrices.isEmpty()) {

			return productPrices.get(4).getText(); // Get the first product's price
		} else {
			return "Price Not Found!";
		}
	}
	
	public String getCurrencySymbol() {
		if (!currencySymbol.isEmpty()) {
			return currencySymbol.get(4).getText();
		} else {
			return "Currency Not Found!";
		}
	}

	public String getBrand() {
		if (!productDetails.isEmpty()) {
			WebElement firstDetail = productDetails.get(0);

			Actions actions = new Actions(driver);
			actions.moveToElement(firstDetail).perform(); // Scrolls until the element is visible
			return firstDetail.getText(); // Get text after scrolling
		} else {
			return "No elements found!";
		}
	}

	public String getOperatingSystem() {
		if (!productDetails.isEmpty()) {
			WebElement secondDetail = productDetails.get(1);
			Actions actions = new Actions(driver);
			actions.moveToElement(secondDetail).perform(); // Scrolls until the element is visible
			return secondDetail.getText(); // Get text after scrolling
		} else {
			return "No elements found!";
		}
	}

	public String getRAM_Memory() {
		if (!productDetails.isEmpty()) {
			WebElement thirdDetail = productDetails.get(2);
			Actions actions = new Actions(driver);
			actions.moveToElement(thirdDetail).perform(); // Scrolls until the element is visible
			return thirdDetail.getText(); // Get text after scrolling
		} else {
			return "No elements found!";
		}
	}

	public String getMemory_Capacity() {
		if (!productDetails.isEmpty()) {
			WebElement fourthDetail = productDetails.get(3);
			Actions actions = new Actions(driver);
			actions.moveToElement(fourthDetail).perform(); // Scrolls until the element is visible
			return fourthDetail.getText(); // Get text after scrolling
		} else {
			return "No elements found!";
		}
	}

	public String getScreens_Size() {
		if (!productDetails.isEmpty()) {
			WebElement fifthDetail = productDetails.get(4);
			Actions actions = new Actions(driver);
			actions.moveToElement(fifthDetail).perform(); // Scrolls until the element is visible
			return fifthDetail.getText(); // Get text after scrolling
		} else {
			return "No elements found!";
		}
	}

}
