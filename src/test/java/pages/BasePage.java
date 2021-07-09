package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

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
        // example of implicit wait
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement Find(String locator) {
        // we make our explicit wait, implicit by depending of the visibility of the element on the page
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
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

    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend) {
        String cellToFill = locator+"/table/tbody/tr/["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // public void validateText(String locator, String textToValidate) {
    //     Assert.assertEquals(textToValidate, Find(locator).getText());
    // }

    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    public boolean elementIsEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    public boolean elemenIsSelected(String locator) {
        return Find(locator).isSelected();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
