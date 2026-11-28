package iscteiul.ista.blackbattleship.selenide124109;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124109.pages.UserStory15Page;
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
 * Testes de aceitação com Selenide para a User Story 15: Sistema de classificação RANKA.
 */
public class UserStory15SelenideTest {

    private UserStory15Page userStory15Page;

    /**
     * Configura o navegador e liga o Selenide ao relatório Allure.
     */
    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "996x692";
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
        userStory15Page = page(UserStory15Page.class);
    }

    /**
     * Fecha o navegador após cada teste.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Verifica que a página RANKA abre e apresenta o título.
     */
    @Test
    @Description("US15 - Abrir a página do sistema de classificação RANKA pelo menu lateral.")
    public void testOpenRankaPage() {
        userStory15Page.rankaLink.shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("ranka"));
        userStory15Page.acceptCookiesIfPresent();
        sleep(1500);

        userStory15Page.pageTitle.shouldBe(visible).click();
        sleep(1500);

        userStory15Page.pageTitle.shouldBe(visible);
    }
}