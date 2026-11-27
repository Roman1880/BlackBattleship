package iscteiul.ista.blackbattleship.selenide124359;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124359.pages.UserStory2Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Testes de aceitação com Selenide para a User Story 2: Jogar online contra um adversário aleatório.
 */
public class UserStory2SelenideTest {

    private UserStory2Page userStory2Page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://papergames.io/en/battleship");
        userStory2Page = page(UserStory2Page.class);
    }

    @Test
    @Description("Verifica a procura de um adversário online aleatório.")
    public void testPlayOnlineRandomOpponent() {
        userStory2Page.playOnlineButton.shouldBe(visible).click();
    }
}