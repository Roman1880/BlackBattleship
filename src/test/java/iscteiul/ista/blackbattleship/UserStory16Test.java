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
 * Testes automatizados para a User Story 16 (Abrir a Batalha Naval a partir da lista de jogos).
 */
public class UserStory16Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory16 userStory16;

    /**
     * Configura o navegador e abre a página inicial do Papergames.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/pt-br/");
        driver.manage().window().setSize(new Dimension(1076, 692));
        userStory16 = new UserStory16(driver);
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
     * Verifica que, ao clicar no cartão da Batalha Naval, abre a página do jogo.
     *
     * @throws InterruptedException se a pausa for interrompida
     */
    @Test
    public void testOpenBattleshipFromGameList() throws InterruptedException {
        userStory16.acceptCookiesIfPresent();
        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(userStory16.battleshipCard)).click();
        wait.until(ExpectedConditions.urlContains("batalha-naval"));
        userStory16.acceptCookiesIfPresent();
        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOf(userStory16.gameTitle)).click();
        Thread.sleep(1500);

        assertTrue(driver.getCurrentUrl().contains("batalha-naval"));
    }
}