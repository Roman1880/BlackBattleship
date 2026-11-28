import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes JUnit da User Story 9.
 * Verifica a navegação para "My tournaments".
 */
public class UserStory9Test {
    private WebDriver driver;
    private UserStory9 page;

    /** Inicializa o Chrome e o respetivo Page Object antes de cada teste. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory9(driver);
    }

    /** Abre o jogo e acede à página "My tournaments". */
    @Test
    void testUserStory9() {
        page.openGame();
        page.openMyTournaments();
        assertTrue(page.isMyTournamentsPageOpen(),
                "Não foi aberta a página My tournaments.");
    }

    /** Fecha o navegador depois de cada teste. */
    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
