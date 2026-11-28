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
 * Page Object correspondente à User Story 15: Consultar o sistema de classificação RANKA.
 */
public class UserStory15 {

    private final WebDriver driver;

    @FindBy(linkText = "RANKA")
    public WebElement rankaLink;

    @FindBy(css = "h1")
    public WebElement pageTitle;

    /**
     * Inicializa os elementos da página para o cenário da US15.
     *
     * @param driver instância do WebDriver utilizada no teste
     */
    public UserStory15(WebDriver driver) {
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