package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public abstract class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    private final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement find(By locator) {
       return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void navigateTo(WebDriver driver, String url) {
        driver.get(url);
    }
    public void goToLinkText(String linkText) {
        try {
            driver.findElement(By.linkText(linkText)).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Link with text '" + linkText + "' not found.");
        }   
}
    public void click(By locator) {
        WebElement element = find(locator);
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    /*public String getText(WebElement mensaje) {
        return find(By.xpath("//*[contains(text(),'" + mensaje + "')]")).getText();
    }*/

    // Verificar si un elemento está visible
    public boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

}
