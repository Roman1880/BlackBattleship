package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object correspondente à User Story 16: Abrir a Batalha Naval a partir da lista de jogos.
 */
public class UserStory16 {

    private final WebDriver driver;

    @FindBy(css = ".game-item:nth-child(1) .img-fluid")
    public WebElement battleshipCard;

    @FindBy(css = ".h3")
    public WebElement gameTitle;

    /**
     * Inicializa os elementos da página para o cenário da US16.
     *
     * @param driver instância do WebDriver utilizada no teste
     */
    public UserStory16(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Aceita o aviso de cookies, se aparecer, e espera que desapareça
     * para não bloquear os cliques seguintes.
     */
    public void acceptCookiesIfPresent() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fc-cta-consent"))).click();
            shortWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".fc-dialog-overlay")));
        } catch (TimeoutException e) {
            // O aviso de cookies não apareceu; o teste continua normalmente.
        }
    }
}