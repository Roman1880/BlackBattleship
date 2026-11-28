import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object da User Story 11.
 * Implementa a interação com a opção "Messaging" registada no .side.
 */
public class UserStory11 {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String GAME_URL =
            "https://papergames.io/en/battleship";

    private final By messagingLink = By.xpath(
            "//a[.//span[contains(normalize-space(.), 'Messaging')]]"
          + " | //a[contains(normalize-space(.), 'Messaging')]"
          + " | //span[contains(normalize-space(.), 'Messaging')]"
    );

    /** Cria o Page Object associado ao navegador indicado. */
    public UserStory11(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /** Abre a página principal do jogo. */
    public void openGame() {
        driver.get(GAME_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    /** Aguarda pela opção "Messaging" e clica nela. */
    public void openMessaging() {
        wait.until(ExpectedConditions.elementToBeClickable(messagingLink)).click();
    }

    /** Verifica se a opção "Messaging" está visível antes da interação. */
    public boolean isMessagingVisible() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(messagingLink)
            ).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
