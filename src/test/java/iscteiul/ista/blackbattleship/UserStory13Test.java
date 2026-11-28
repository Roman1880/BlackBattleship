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
 * Testes automatizados para a User Story 13 (Explorar a loja).
 */
public class UserStory13Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory13 userStory13;

    /**
     * Configura o navegador e abre a página inicial do Papergames.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/pt-br/");
        driver.manage().window().setSize(new Dimension(996, 692));
        userStory13 = new UserStory13(driver);
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
     * Verifica que a loja abre e que a secção de emojis é apresentada.
     *
     * @throws InterruptedException se a pausa for interrompida
     */
    @Test
    public void testOpenShopEmojis() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userStory13.shopLink)).click();
        wait.until(ExpectedConditions.urlContains("shop"));
        userStory13.acceptCookiesIfPresent();
        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(userStory13.emojisSection)).click();
        Thread.sleep(1500);

        assertTrue(driver.getCurrentUrl().contains("shop"));
    }
}