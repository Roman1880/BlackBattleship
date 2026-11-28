package iscteiul.ista.blackbattleship.selenide124109.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object (Selenide) correspondente à User Story 17: Consultar o registo de alterações.
 */
public class UserStory17Page {

    @FindBy(linkText = "Changelog")
    public SelenideElement changelogLink;

    @FindBy(id = "changelog")
    public SelenideElement changelogList;

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