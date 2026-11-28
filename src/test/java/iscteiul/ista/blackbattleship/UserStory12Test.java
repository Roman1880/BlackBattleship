import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes JUnit da User Story 12.
 * Verifica a navegação para o histórico de jogos ("History").
 */
public class UserStory12Test {
    private WebDriver driver;
    private UserStory12 page;

    /** Inicializa o Chrome e o respetivo Page Object antes de cada teste. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory12(driver);
    }

    /** Abre o jogo, seleciona History e verifica o endereço de destino. */
    @Test
    void testUserStory12() {
        page.openGame();
        page.openHistory();
        assertTrue(page.isHistoryPageOpen(),
                "Não foi aberta a página History.");
    }

    /** Fecha o navegador depois de cada teste. */
    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
