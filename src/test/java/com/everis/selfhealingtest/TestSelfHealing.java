package com.everis.selfhealingtest;

import java.io.IOException;

//import com.epam.healenium.SelfHealingDriver;
import com.everis.selfhealingtest.PageObjects.FormPageObject;
import com.everis.selfhealingtest.Utils.Utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Exemplo de utilização do Healenium
 */
public class TestSelfHealing {
    static WebDriver oDriver;

    /**
     * Inicializa o driver
     */
    @BeforeAll
    public static void abre() {
        oDriver = new ChromeDriver();
    }

    /**
     * Executa o teste
     */
    @Test
    public void testePreenchimentoForm() {
        
        //SelfHealingDriver driver = SelfHealingDriver.create(oDriver);
        WebDriver driver = oDriver;
        
        FormPageObject pageObject = new FormPageObject(driver);
        pageObject.abrePagina("form.html");
        pageObject.preencheForm("José da Silva", "noone@home.com", "11 7070.7070", "http://www.ghoogle.com",
                "Título da mensagem", "Mensagem a enviar");
        pageObject.verificaPreenchimentoDaMensagem("Mensagem a enviar");
    }

    /**
     * Tira um print da tela após o teste
     * @throws IOException
     */
    @AfterEach
    public void geraScreenshot() throws IOException {
        Utils.generateScreenshot(oDriver);
    }

    /**
     * Libera o driver e fecha o browser
     */
    @AfterAll
    public static void close() {
        oDriver.close();
    }

}
