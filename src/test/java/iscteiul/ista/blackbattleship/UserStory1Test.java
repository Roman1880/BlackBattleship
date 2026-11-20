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
 * Testes automatizados para a User Story 1 (Jogar contra o robô).
 */
public class UserStory1Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory1 userStory1;

    /**
     * Configura o navegador e abre a página do jogo Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().setSize(new Dimension(1280, 800));
        userStory1 = new UserStory1(driver);
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
     * Verifica o início de uma partida contra o robô e o posicionamento de navios no tabuleiro.
     */
    @Test
    public void testPlayAgainstRobot() {
        wait.until(ExpectedConditions.elementToBeClickable(userStory1.playVsRobotButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory1.firstShipCell)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory1.confirmShipPosition)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory1.secondShipSelector)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory1.confirmShipPosition)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory1.thirdShipSelector)).click();

        assertTrue(driver.getCurrentUrl().contains("battleship"));
    }
}