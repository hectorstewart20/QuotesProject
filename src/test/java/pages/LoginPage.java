package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[type='submit']");
    private By logoutLink = By.linkText("Logout");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }
    public void clickLogin() {
        click(loginButton);
    }
    public void clickLogout() {
        click(logoutLink);
    }

  public String generateInputLogin(String valorEjemplo) {
    if (valorEjemplo.contains("255")) return "a".repeat(255);
    if (valorEjemplo.contains("256")) return "a".repeat(256);
    return valorEjemplo;
}

  public void clickLink(String linkText) {
        find(By.linkText(linkText)).click();
  }

  public boolean isLinkVisible(String linkText) {
        return isDisplayed(By.linkText(linkText));
  }
    /*public String getErrorMessage(String mensajeEsperado) {
        WebElement mensaje = driver.findElement(By.xpath("//*[contains(text(),'" + mensajeEsperado + "')]"));
        return getText(mensaje);
    }*/
}
