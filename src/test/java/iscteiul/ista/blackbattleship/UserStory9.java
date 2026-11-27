import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object da User Story 9.
 * Implementa a navegação para a área "My tournaments".
 *
 * O localizador é baseado no texto e no href alternativo registado
 * no ficheiro TestSuite_87711.side.
 */
public class UserStory9 {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String GAME_URL =
            "https://papergames.io/en/battleship";

    private final By myTournamentsLink = By.xpath(
            "//a[contains(@href, '/en/t/my-tournaments')]"
          + " | //a[.//span[contains(normalize-space(.), 'My tournaments')]]"
          + " | //span[contains(normalize-space(.), 'My tournaments')]"
    );

    /** Cria o Page Object associado ao navegador indicado. */
    public UserStory9(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /** Abre a página principal do jogo. */
    public void openGame() {
        driver.get(GAME_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    /** Clica na ligação "My tournaments". */
    public void openMyTournaments() {
        wait.until(ExpectedConditions.elementToBeClickable(myTournamentsLink)).click();
    }

    /** Aguarda até que o endereço indique a área dos torneios. */
    public boolean isMyTournamentsPageOpen() {
        try {
            return wait.until(ExpectedConditions.urlContains("/en/t/my-tournaments"));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
