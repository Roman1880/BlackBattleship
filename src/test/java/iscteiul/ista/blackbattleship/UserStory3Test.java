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
 * Testes automatizados para a User Story 3 (Convidar um amigo através de link).
 */
public class UserStory3Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory3 userStory3;

    /**
     * Configura o navegador e abre a página do jogo Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().setSize(new Dimension(1280, 800));
        userStory3 = new UserStory3(driver);
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
     * Verifica a criação de uma sala privada e a cópia do link de convite.
     */
    @Test
    public void testInviteFriendViaLink() {
        wait.until(ExpectedConditions.elementToBeClickable(userStory3.playWithFriendButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory3.copyInviteLinkButton)).click();
        assertTrue(driver.getCurrentUrl().contains("battleship"));
    }
}