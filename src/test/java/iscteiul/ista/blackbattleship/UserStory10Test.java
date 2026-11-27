import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes JUnit da User Story 10.
 * Reproduz a sequência Remove ads, barra lateral, Pricing,
 * barra lateral e API gravada no ficheiro .side.
 */
public class UserStory10Test {
    private WebDriver driver;
    private UserStory10 page;

    /** Inicializa o Chrome e o respetivo Page Object antes de cada teste. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory10(driver);
    }

    /** Executa a sequência de navegação gravada e verifica o destino API. */
    @Test
    void testUserStory10() {
        page.openGame();
        page.clickRemoveAds();
        page.toggleSidebar();
        page.clickPricing();
        page.toggleSidebar();
        page.clickApi();

        assertTrue(page.isApiPageOpen(),
                "Não foi aberta a página API (Games as a Service).");
    }

    /** Fecha o navegador depois de cada teste. */
    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
