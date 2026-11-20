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
 * Testes automatizados para a User Story 2 (Jogar online contra adversário aleatório).
 */
public class UserStory2Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory2 userStory2;

    /**
     * Configura o navegador e abre a página do jogo Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().setSize(new Dimension(1280, 800));
        userStory2 = new UserStory2(driver);
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
     * Verifica a procura de um adversário online aleatório.
     */
    @Test
    public void testPlayOnlineRandomOpponent() {
        wait.until(ExpectedConditions.elementToBeClickable(userStory2.playOnlineButton)).click();
        assertTrue(driver.getCurrentUrl().contains("battleship"));
    }
}