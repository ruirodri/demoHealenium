package com.everis.selfhealingtest.PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import com.everis.selfhealingtest.Utils.Utils;

import org.openqa.selenium.WebDriver;

public class FormPageObject {

    private WebDriver driver;

    private final String locatorNome = "/html/body/form/ul/li[1]/input[1]";
    private final String locatorEmail = "/html/body/form/ul/li[1]/input[2]";

    private final String locatorPhone = "/html/body/form/ul/li[2]/input[1]";
    private final String locatorWebsite = "/html/body/form/ul/li[2]/input[2]";

    private final String locatorSubject = "/html/body/form/ul/li[3]/input";

    private final String locatorMessage = "/html/body/form/ul/li[4]/textarea";

    /**
     * Constructor que recebe o WebDriver como parâmetro
     * @param driver
     */
    public FormPageObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Método que acessa a URL que tem a página a ser automatizada
     * 
     * @param url
     */
    public void abrePagina(String url) {
        File file = new File("html/" + url);
        driver.get(file.getAbsolutePath());
    }

    /**
     * Método que recebe os dados a preencher no form e concretiza o preenchimento.
     * 
     * @param nome
     * @param email
     * @param phone
     * @param website
     * @param subject
     * @param message
     */
    public void preencheForm(String nome, String email, String phone, String website, String subject, String message) {
        Utils.fillByXpath(driver, locatorNome, nome);
        Utils.fillByXpath(driver, locatorEmail, email);
        Utils.fillByXpath(driver, locatorPhone, phone);
        Utils.fillByXpath(driver, locatorWebsite, website);
        Utils.fillByXpath(driver, locatorSubject, subject);
        Utils.fillByXpath(driver, locatorMessage, message);
    }

    /**
     * Verifica se o preenchimento da mensagem foi como esperado
     * @param message
     */
    public void verificaPreenchimentoDaMensagem(String message) {
        assertEquals(message, Utils.getWebElementByXpath(driver, locatorMessage).getAttribute("value"));
    }

}
