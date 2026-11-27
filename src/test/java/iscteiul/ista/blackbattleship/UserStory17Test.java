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
 * Testes automatizados para a User Story 17 (Consultar o registo de alterações).
 */
public class UserStory17Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserStory17 userStory17;

    /**
     * Configura o navegador e abre a página inicial do Papergames.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://papergames.io/pt-br/");
        driver.manage().window().setSize(new Dimension(1076, 692));
        userStory17 = new UserStory17(driver);
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
     * Verifica que a página do changelog abre e apresenta a lista de atualizações.
     *
     * @throws InterruptedException se a pausa for interrompida
     */
    @Test
    public void testOpenChangelog() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userStory17.changelogLink)).click();
        userStory17.acceptCookiesIfPresent();
        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOf(userStory17.changelogList)).click();
        Thread.sleep(1500);

        assertTrue(userStory17.changelogList.isDisplayed());
    }
}