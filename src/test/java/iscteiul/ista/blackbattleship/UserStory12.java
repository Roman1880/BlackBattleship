import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object da User Story 12.
 * Implementa a navegação para o histórico de jogos ("History").
 */
public class UserStory12 {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String GAME_URL =
            "https://papergames.io/en/battleship";

    private final By historyLink = By.xpath(
            "//a[contains(@href, '/en/match-history')]"
          + " | //a[normalize-space(.)='History']"
          + " | //a[contains(., 'History')]"
    );

    /** Cria o Page Object associado ao navegador indicado. */
    public UserStory12(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /** Abre a página principal do jogo. */
    public void openGame() {
        driver.get(GAME_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    /** Clica na ligação "History". */
    public void openHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(historyLink)).click();
    }

    /** Aguarda e verifica se o endereço corresponde ao histórico de jogos. */
    public boolean isHistoryPageOpen() {
        try {
            return wait.until(ExpectedConditions.urlContains("/en/match-history"));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
