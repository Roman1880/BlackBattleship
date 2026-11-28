package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes automatizados para a User Story 15 (Sistema de classificação RANKA).
 */
public class UserStory15Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory15 userStory15;

    /**
     * Configura o navegador e abre a página inicial do Papergames.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/pt-br/");
        driver.manage().window().setSize(new Dimension(996, 692));
        userStory15 = new UserStory15(driver);
    }

    /**
     * Fecha o navegador após a execução do teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Verifica que a página RANKA abre e apresenta o título.
     *
     * @throws InterruptedException se a pausa for interrompida
     */
    @Test
    public void testOpenRankaPage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userStory15.rankaLink)).click();
        wait.until(ExpectedConditions.urlContains("ranka"));
        userStory15.acceptCookiesIfPresent();
        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOf(userStory15.pageTitle)).click();
        Thread.sleep(1500);

        assertTrue(userStory15.pageTitle.isDisplayed());
    }
}