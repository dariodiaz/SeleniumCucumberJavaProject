package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        // sets browser to Chrome
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "latest");
        // instantiates a remote WebDriver object with your desired capabilities
        try {
            System.setProperty("webdriver.chrome.driver", "../chromedriver");
            driver = new ChromeDriver();
        } catch (IllegalStateException e) {
            System.setProperty("webdriver.chrome.driver", "../chromedriver");
            driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
}
