package iscteiul.ista.blackbattleship.selenide124109;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124109.pages.UserStory16Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

/**
 * Testes de aceitação com Selenide para a User Story 16: Abrir a Batalha Naval a partir da lista de jogos.
 */
public class UserStory16SelenideTest {

    private UserStory16Page userStory16Page;

    /**
     * Configura o navegador e liga o Selenide ao relatório Allure.
     */
    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1076x692";
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /**
     * Abre a página inicial do Papergames.
     */
    @BeforeEach
    public void setUp() {
        open("https://papergames.io/pt-br/");
        userStory16Page = page(UserStory16Page.class);
    }

    /**
     * Fecha o navegador após cada teste.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Verifica que, ao clicar no cartão da Batalha Naval, abre a página do jogo.
     */
    @Test
    @Description("US16 - Abrir a Batalha Naval a partir da lista de jogos da página inicial.")
    public void testOpenBattleshipFromGameList() {
        userStory16Page.acceptCookiesIfPresent();
        sleep(1500);

        userStory16Page.battleshipCard.shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("batalha-naval"));
        userStory16Page.acceptCookiesIfPresent();
        sleep(1500);

        userStory16Page.gameTitle.shouldBe(visible).click();
        sleep(1500);

        webdriver().shouldHave(urlContaining("batalha-naval"));
    }
}