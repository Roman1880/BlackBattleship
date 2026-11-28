package iscteiul.ista.blackbattleship.selenide124109;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124109.pages.UserStory17Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Testes de aceitação com Selenide para a User Story 17: Consultar o registo de alterações.
 */
public class UserStory17SelenideTest {

    private UserStory17Page userStory17Page;

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
        userStory17Page = page(UserStory17Page.class);
    }

    /**
     * Fecha o navegador após cada teste.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Verifica que a página do changelog abre e apresenta a lista de atualizações.
     */
    @Test
    @Description("US17 - Abrir o changelog pelo menu lateral e ver a lista de atualizações.")
    public void testOpenChangelog() {
        userStory17Page.changelogLink.shouldBe(visible).click();
        userStory17Page.acceptCookiesIfPresent();
        sleep(1500);

        userStory17Page.changelogList.shouldBe(visible).click();
        sleep(1500);

        userStory17Page.changelogList.shouldBe(visible);
    }
}