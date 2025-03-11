package pom;

import org.openqa.selenium.*;
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

	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	private List<WebElement> productList;

	@FindBy(xpath = "//span[@class='a-price-whole']")
	private List<WebElement> productPrices;

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement productTitle;

	public DemoTest(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	public void searchProduct(String product) {
		productName.sendKeys(product);
		searchButton.click();
	}

	public int getProductCount() {
		wait.until(ExpectedConditions.visibilityOfAllElements(productList)); // Ensure products are visible
		return productList.size();
	}

	public void clickFirstProduct() {
		List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")));
		if (!productList.isEmpty()) {
			productList.get(0).click();
		}

	}

	public String getProductPrice() {

		if (!productPrices.isEmpty()) {

			return productPrices.get(4).getText().trim(); // Get the first product's price
		} else {
			return "Price Not Found!";
		}
	}
}
