package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginLink = By.cssSelector("a[href='/login']");
    private By logoutLink = By.cssSelector("a[href='/logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void clickLogoutLink() {
        click(logoutLink);
    }
    public boolean isLogoutLinkDisplayed() {
        return isDisplayed(logoutLink);
    }
    public boolean isLoginLinkDisplayed() {
        return isDisplayed(loginLink);
    }
}
