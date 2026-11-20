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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes automatizados para a User Story 4 (Alterar o nickname do jogador).
 */
public class UserStory4Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory4 userStory4;

    /**
     * Configura o navegador e abre a página do jogo Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().setSize(new Dimension(1280, 800));
        userStory4 = new UserStory4(driver);
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
     * Verifica a alteração do nickname do utilizador para "bo11".
     */
    @Test
    public void testChangeNickname() {
        wait.until(ExpectedConditions.elementToBeClickable(userStory4.userProfileMenuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory4.changeNicknameMenuOption)).click();
        wait.until(ExpectedConditions.visibilityOf(userStory4.nicknameInputField)).click();
        userStory4.nicknameInputField.clear();
        userStory4.nicknameInputField.sendKeys("bo11");
        wait.until(ExpectedConditions.elementToBeClickable(userStory4.updateNicknameButton)).click();

        wait.until(ExpectedConditions.textToBePresentInElement(userStory4.userProfileMenuButton, "bo11"));
        assertEquals("bo11", userStory4.userProfileMenuButton.getText().trim());
    }
}