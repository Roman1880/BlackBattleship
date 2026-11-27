import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes JUnit da User Story 11.
 * Verifica se a opção "Messaging" está disponível e permite selecioná-la.
 */
public class UserStory11Test {
    private WebDriver driver;
    private UserStory11 page;

    /** Inicializa o Chrome e o respetivo Page Object antes de cada teste. */
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory11(driver);
    }

    /** Abre o jogo, confirma a visibilidade de Messaging e clica na opção. */
    @Test
    void testUserStory11() {
        page.openGame();
        assertTrue(page.isMessagingVisible(),
                "A opção Messaging não está visível.");
        page.openMessaging();
    }

    /** Fecha o navegador depois de cada teste. */
    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
