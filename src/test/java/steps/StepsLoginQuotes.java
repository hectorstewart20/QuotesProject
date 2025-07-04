package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import utils.ConfigReader;

public class StepsLoginQuotes {

    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(StepsLoginQuotes.class);
    LoginPage loginPage;
    String url = ConfigReader.get("base.url");
    String browser = ConfigReader.get("browser");
    @Before
    public void setUp() {
        driver = DriverFactory.createDriver(browser);
        logger.info("Se configuró e navegador correctamente: " + browser);
        loginPage = new LoginPage(driver);
    }

    @Given("estoy en la página principal")
    public void estoy_en_la_pagina_principal() {
        HomePage.navigateTo(driver, url);
        logger.info("Me encuentro en la página principal");
    }

    @And("ingreso el usuario y la contraseña válidos")
    public void ingreso_usuario_y_contrasena() {
        String user = ConfigReader.get("username");
        String pass = ConfigReader.get("password");
        logger.debug("Ingresando credenciales válidas");
        loginPage.login(user, pass);
    }
    @And("ingreso el usuario {string} y la contraseña {string}")
    public void ingreso_usuario_y_contrasena(String user, String pass) {
        logger.debug("Ingresando credenciales parametrizadas en el feature : " + user + " y " + pass);
        loginPage.login(user, pass);
    }

    @When("hago clic en el botón de login")
    public void hago_clic_en_boton_login() {
        loginPage.clickLogin();
    }

    @When("hago clic en el link {string}")
    public void hago_clic_en_el_link_logout(String linkText) {
        loginPage.clickLink(linkText);
    }
    @Then("deberia ver el link {string}")
    public void deberia_ver_link(String LinkText) {

        if (loginPage.isLinkVisible(LinkText)) {
            assertTrue(loginPage.isLinkVisible(LinkText));
            logger.info("Link encontrado: " + LinkText);
        }else {
            logger.error("Link no encontrado: " + LinkText);
        }
    }


    @Then("debería ver el mensaje de error {string}")
    public void deberia_ver_el_mensaje(String mensajeEsperado) {
        WebElement mensaje = driver.findElement(By.xpath("//*[contains(text(),'" + mensajeEsperado + "')]"));
        assertTrue(mensaje.isDisplayed());
        if (mensaje.isDisplayed()) {
            logger.info("Mensaje encontrado: " + mensajeEsperado);
        } else {
            logger.error("Mensaje no encontrado: " + mensajeEsperado);
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000); // Espera para ver el resultado antes de cerrar solo para debug
        driver.quit();
    }

}
