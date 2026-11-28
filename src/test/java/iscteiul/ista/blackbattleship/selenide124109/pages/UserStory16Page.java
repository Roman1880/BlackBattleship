package iscteiul.ista.blackbattleship.selenide124109.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object (Selenide) correspondente à User Story 16: Abrir a Batalha Naval a partir da lista de jogos.
 */
public class UserStory16Page {

    @FindBy(css = ".game-item:nth-child(1) .img-fluid")
    public SelenideElement battleshipCard;

    @FindBy(css = ".h3")
    public SelenideElement gameTitle;

    /**
     * Aceita o aviso de cookies, se aparecer, para não bloquear os cliques.
     */
    public void acceptCookiesIfPresent() {
        try {
            $(".fc-cta-consent").should(appear, Duration.ofSeconds(8)).click();
            $(".fc-dialog-overlay").should(disappear, Duration.ofSeconds(8));
        } catch (UIAssertionError e) {
            // O aviso de cookies não apareceu; o teste continua normalmente.
        }
    }
}