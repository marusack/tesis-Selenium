package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public int timeout = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public void go(String url) {
        driver.get(url);
    }

    public void clickJs(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Verifies if the element in enabled and displayed to the user
     *
     * @param element
     * @return
     */
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    /**
     * @param by
     */
    public void waitToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    /**
     * Checks message to be displayed in the page
     *
     * @param msg
     * @return
     */
    public boolean isMessageDisplayed(WebDriver driver, String msg) {
        try {
            String locator = "//body//*[text()=\"" + msg + "\"]";
            waitToBeVisible(By.xpath(locator));
            WebElement element = driver.findElement(By.xpath(locator));

            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }


}
