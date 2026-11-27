import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object da User Story 10.
 * Reproduz a sequência gravada para aceder às opções Remove ads,
 * Pricing e API.
 */
public class UserStory10 {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String GAME_URL =
            "https://papergames.io/en/battleship";

    private final By removeAdsLink = By.xpath(
            "//a[contains(normalize-space(.), 'Remove ads')]"
          + " | //a[contains(@href, '/en/pricing/plus')]"
    );
    private final By sidebarToggle = By.cssSelector(".fa-angles-right");
    private final By pricingLink = By.xpath(
            "//a[.//span[contains(normalize-space(.), 'Pricing')]]"
          + " | //a[contains(normalize-space(.), 'Pricing')]"
    );
    private final By apiLink = By.xpath(
            "//a[contains(@href, '/en/pricing/games-as-a-service')]"
          + " | //a[normalize-space(.)='API']"
    );

    /** Cria o Page Object associado ao navegador indicado. */
    public UserStory10(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /** Abre a página principal do jogo. */
    public void openGame() {
        driver.get(GAME_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    /** Seleciona a ligação "Remove ads". */
    public void clickRemoveAds() {
        wait.until(ExpectedConditions.elementToBeClickable(removeAdsLink)).click();
    }

    /**
     * Abre ou fecha a barra lateral através do respetivo controlo.
     * O mesmo controlo foi gravado duas vezes no ficheiro .side.
     */
    public void toggleSidebar() {
        wait.until(ExpectedConditions.elementToBeClickable(sidebarToggle)).click();
    }

    /** Seleciona a opção "Pricing" na barra lateral. */
    public void clickPricing() {
        wait.until(ExpectedConditions.elementToBeClickable(pricingLink)).click();
    }

    /** Seleciona a opção "API". */
    public void clickApi() {
        wait.until(ExpectedConditions.elementToBeClickable(apiLink)).click();
    }

    /** Indica se o endereço atual corresponde à página de API. */
    public boolean isApiPageOpen() {
        try {
            return wait.until(ExpectedConditions.urlContains(
                    "/en/pricing/games-as-a-service"));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
